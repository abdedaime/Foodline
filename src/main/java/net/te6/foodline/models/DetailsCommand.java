package net.te6.foodline.models;

/**
 * Created by hicham on 08/02/2017.
 */

public class DetailsCommand {
    private long id;
    private int quantity;
    private Command command;
    private Food food;


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Command getCommand() {
        return command;
    }

    public void setCommand(Command command) {
        this.command = command;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DetailsCommand that = (DetailsCommand) o;

        if (id != that.id) return false;
        if (quantity != that.quantity) return false;
        return command != null ? command.equals(that.command) : that.command == null;

    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + quantity;
        result = 31 * result + (command != null ? command.hashCode() : 0);
        return result;
    }

    public Food getFood() {
        return food;
    }

    public void setFood(Food food) {
        this.food = food;
    }
}
