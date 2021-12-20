package easy.day2;

public class t {
    public static void main(String[] args){
        Pizza pizza = new Pizza();
        pizza.setStatus(Pizza.PizzaStatus.ORDERED);
        pizza.printTimeToDeliver();
        System.out.println(pizza.isDeliverable());
        System.out.println(pizza.getStatus());
    }
}
