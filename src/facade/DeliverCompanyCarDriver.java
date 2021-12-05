package facade;

public class DeliverCompanyCarDriver implements Driver {

    @Override
    public String deliverOrder(int number) {
        return "Order with number " + number + " delivered";
    }

}
