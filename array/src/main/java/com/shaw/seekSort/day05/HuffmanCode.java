package com.shaw.seekSort.day05;

import com.sun.beans.editors.ByteEditor;
import org.omg.CosNaming.IstringHelper;
import sun.security.util.Length;

import java.util.*;

/**
 * @author: xsy
 * @Date: 2022/1/11
 * @description: the code use in the file by huffmanTree encryption
 */
public class HuffmanCode {
    public static void main(String[] args) {
        //i like like like java do you like a java qreq eqdsDvsFEQERVCSAr
        String str = "i i o"; // 长度是40
        byte[] bytes = str.getBytes();
        List<Node2> Node2s = getNode2(bytes);
        Node2 huffmanTree = createHuffmanTree(Node2s);
        huffmanTree.preOrder();
        //	getCodes(huffmanTree,"" , stringBuilder);
        Map<Byte, String> codes = getCodes(huffmanTree);
        System.out.println("生成的哈夫曼编码表:" + codes);

        // 测试
        byte[] zip = zip(bytes, codes);
        System.out.println("哈夫曼编码压缩过后的bytes "+ Arrays.toString(zip)); // 长度是17

        // 封装类的测试
        System.out.println("封装类的测试");
        byte[] huffmanZip = huffmanZip(bytes);
        System.out.println("哈夫曼编码压缩过后的bytes "+ Arrays.toString(huffmanZip));

        // 解码测试
        byte[] source = decode(huffmanCode, huffmanZip);
        System.out.println("原来的字符串 "+new String(source));
    }

    /**
     *       编写一个方法将字符串对应的byte[]数组 通过生成的哈夫曼编码表 返回一个哈夫曼编码 压缩后的byte数组
     * @param bytes 原始的字符串对应的byte[]数组
     * @param huffmanCode 生成得Huffman编码
     * @return 返回哈夫曼树编码处理后的byte[]
     * 当前例子将会返回(类似 因为生成得Huffman树的结构不同 但是长度会相同)1010100010111111110010001011111111001000101111111100100101001101110001110000011011101000111100101000
     * 101111111100110001001010011011100
     * =>对应的byte[] 数组 放入 8个数字 对应一个byte 放入数组 例如
     * 10101000(补码) => byte (10101000 => 10101000 -1 => 10100111(反码) => 11011000(源码) =>-88)
     */
    private static byte[] zip(byte[] bytes, Map<Byte,String> huffmanCode){
        // 1 先用Huffman编码表 将bytes 转成 Huffman编码对应的字符串
        StringBuilder stringBuilder = new StringBuilder();
        // 遍历byte数组
        for(byte b : bytes){
            stringBuilder.append(huffmanCode.get(b));
        }
        System.out.println(stringBuilder.toString());
        // 2 将01010001011111....转为一个byte数组
        // 如果被8乘除 就是stringBuilder.length()/8 没有没整除就是 (stringBuilder.length()+1)/8
        int num = (stringBuilder.length()+7) / 8;
        // 创建 一个存储压缩后的byte数组
        byte[] huffmanCodeBytes = new byte[num];
        int index = 0; // 第几个byte
        for (int i = 0; i < stringBuilder.length(); i+=8){// 步长为8
            String strByte;
            if(i + 8 > stringBuilder.length()) {// 不够8位
                strByte = stringBuilder.substring(i);  // i-结束
            }else {
                strByte = stringBuilder.substring(i, i + 8);
            }
            huffmanCodeBytes[index++] = (byte) Integer.parseInt(strByte,2); // 二进制
        }
        return huffmanCodeBytes;
    }

    // 使用一个方法 将前面的方法封装起来 ,便于调用

    /**
     * @param bytes 原始的字符串对应的字节数组
     * @return 返回的是经过哈夫曼编码处理后(压缩后)的数组
     */
    private static byte[] huffmanZip(byte[] bytes) {
        List<Node2> Node2s = getNode2(bytes);
        // 创建哈夫曼树
        Node2 huffmanTreeRoot = createHuffmanTree(Node2s);
        // 根据哈夫曼树生成对应的哈夫曼编码
        Map<Byte, String> huffmanCodes = getCodes(huffmanTreeRoot);
        // 根据生成的哈夫曼编码 对原来的数据进行封装 得到压缩后的哈夫曼树的编码
        byte[] zip = zip(bytes, huffmanCodes);
        return zip;

    }

    // 完成数据的解压
    // 思路
    // 1 将huffmanCodeBytes [40, 46, -56, 46, -56, 46, -55, 5, -123, 6, -88, -46, -126, -20, -124, -126, 24 ]
    // 重新转成赫夫曼编码对应的字符串 100100100...
    // 2 将赫夫曼对应的二进制字符串 100100100... 对照 哈夫曼编码转成 i like java......

    /**
     * 将byte 转成一个二进制的字符串
     * @param flag 标志当前是否需要补高位  如果是true 需要补高位
     * @param b 传入的byte
     * @return 返回  b 对应二进制的字符串(补码返回)
     */
    private static String byteToBitString(boolean flag,byte b){
        int temp = b; // 向上强转 b变成int
        // 如果是整数 需要补高位
        if(flag) { // 如果当前长度 没有8位 不用高位补码
            temp |= 256; // 按位与 256 =1 0000 0000   1 = 0000 0001 => 1 0000 0001
        }
        String str = Integer.toBinaryString(temp); // 返回temp 对应二进制的补码
        if (flag) {
            return str.substring(str.length() - 8); // 取最后8位
        }else {
            return str;
        }
    }

    /**
     * 编写有个方法  完成对压缩数据的编码
     * @param huffmanCode 哈夫曼编码表
     * @param huffmanBytes 哈夫曼编码的得到的字节数组
     * @return  原理的字符串对应的数组
     */
    private static byte[] decode(Map<Byte,String> huffmanCode, byte[] huffmanBytes){
        // 1 先得到 huffmanBytes 的二进制的字符串 形式为"10101010..."
        StringBuilder stringBuilder = new StringBuilder();
        // 将byte数组转成二进制的字符串
        boolean flag = false;
        for(int i = 0; i < huffmanBytes.length; i++){
            // 判断是不是最后一个字节
            if (huffmanBytes.length-1 == i){
                flag = true;
            }
            stringBuilder.append(byteToBitString(!flag,huffmanBytes[i]));
        }
        //	System.out.println("哈弗曼树对应的二进制字符串是 "+stringBuilder.toString());
        // 把字符串安装到指定的哈夫曼编码进行解码
        // 把哈夫曼树编码进行调换 因为反向查询 a -> 100 100->a
        Map<String, Byte> map = new HashMap<>();
        for (Map.Entry<Byte,String> entry : huffmanCode.entrySet()){
            map.put(entry.getValue(), entry.getKey());
        }
        //System.out.println(map);
        //创键一个集合 存放byte
        List<Byte> list = new ArrayList<>();
        // i理解成是一个索引 扫描stringBuilder
        for (int i = 0; i < stringBuilder.length();){
            int count = 1; // 小的计数器
            flag = true;
            Byte b = null;
            while (flag) {
                // 取出一个'1'或'0' 组建key 去map{000=108, 01=32, 001=105, 01000=100, 01011=118...中查找
                String key = stringBuilder.substring(i, i + count);// i 不动 让count移动// 直到匹配到一个字符

                b = map.get(key);
                if (b == null) {
                    count++;
                } else {
                    //匹配到了
                    flag = false;

                }
            }
            list.add(b); i += count;
        }
        // for循环结束后 list就存放了所有字符
        // 把list中的数据放入byte数组中
        byte[] b = new byte[list.size()];
        for (int i = 0; i < b.length; i++){
            b[i] = list.get(i);
        }
        return b;
    }


    /**
     *   构建字节Node2数组
     * @param bytes 字节数组
     * @return  返回Node2数组
     */
    public static List<Node2> getNode2(byte[] bytes){
        // 创建一个arrayList
        ArrayList<Node2> Node2s = new ArrayList<>();

        // 存储每一个byte出现的次数  map来做
        HashMap<Byte, Integer> map = new HashMap<Byte, Integer>();
        for (byte b : bytes){
            Integer count = map.get(b);
            if (count == null){
                map.put(b, 1);
            }else {
                map.put(b, ++count);
            }
        }
        // 每个键值对转成Node2对象  并加入Node2s
        // 遍历map
        for(Map.Entry<Byte,Integer> entry : map.entrySet()){
            Node2s.add(new Node2(entry.getKey(), entry.getValue()));
        }
        return Node2s;
    }

    // 构建哈夫曼树
    public static Node2 createHuffmanTree(List<Node2> Node2s){
        if (Node2s.size() == 0){
            System.out.println("数组为空 无法构建哈夫曼树");
            return null;
        }
        Collections.sort(Node2s);
        while (Node2s.size() > 1){
            Collections.sort(Node2s);
            Node2 left = Node2s.get(0);
            Node2 right = Node2s.get(1);
            Node2 Node2 = new Node2(null,left.weight + right.weight);
            Node2.left = left;
            Node2.right = right;
            Node2s.remove(left);
            Node2s.remove(right);
            Node2s.add(Node2);
        }
        return Node2s.get(0);
    }

    // 生成哈夫曼对应的哈夫曼编码
    // 1 将哈夫曼树放在Map<Byte,String> 形式大概为 a->100 d->11000 u->11001 e->1110 v->11011 i->101 y->11010 j->0010 k->1111 l->000 o->0011
    // 2 在生成哈夫曼编码表时 需要拼接路径  定义一个stringBuilder 存储某个叶子节点的路径
    static Map<Byte,String> huffmanCode = new HashMap<>();
    static StringBuilder stringBuilder = new StringBuilder();


    // 为了调用方便 重载getCodes
    private static Map<Byte, String> getCodes(Node2 root) {
        if (root == null){
            return null;
        }
        // 处理root的左子树
        getCodes(root.left, "0", stringBuilder);
        getCodes(root.right, "1", stringBuilder);
        return huffmanCode;

    }

    /**
     *       将传入的Node2节点的所有叶子节点的哈夫曼编码得到 , 并放入到HuffmanCodes集合中
     * @param Node2 传入节点 默认根节点
     * @param code 路径 左子节点为 0 右子节点为 1
     * @param stringBuilder 拼接路径
     */
    private static void getCodes(Node2 Node2, String code, StringBuilder stringBuilder){
        StringBuilder stringBuilder2 = new StringBuilder(stringBuilder);
        stringBuilder2.append(code);
        if (Node2 != null){
            if (Node2.data == null){ // 非叶子节点
                getCodes(Node2.left,"0",stringBuilder2);
                getCodes(Node2.right,"1",stringBuilder2);
            }else {
                huffmanCode.put(Node2.data, stringBuilder2.toString());
            }
        }

    }
}

// 创建Node2 ,带数据和权值
class Node2 implements Comparable<Node2>{
    Byte data; // 存放数据本身 比如'a' => 97 ' '=> 32
    int weight; // 权值 表示数据(字符) 出现的次数
    Node2 left;
    Node2 right;

    public Node2(Byte data, int weight) {
        this.data = data;
        this.weight = weight;
    }


    @Override
    public int compareTo(Node2 o) {
        // weight 升序排列
        return this.weight - o.weight;
    }

    @Override
    public String toString() {
        return "Node2{" +
                "data=" + data +
                ", weight=" + weight +
                '}';
    }
    // 前序遍历
    public  void preOrder(){
        System.out.println(this);
        if(this.left != null){
            this.left.preOrder();
        }
        if(this.right != null){
            this.right.preOrder();
        }
    }
}

