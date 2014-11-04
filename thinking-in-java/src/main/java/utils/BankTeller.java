package utils;

import generics.Generators;

import java.util.*;

/**
 * Created by Intellij idea.
 *
 * @author Thomson Tang
 */

class Customer {
    private static long counter = 1;
    private final long id = counter++;

    private Customer() {
    }

    public String toString() {
        return "Customer " + id;
    }

    public static Generator<Customer> generator() {
        return new Generator<Customer>() {
            @Override public Customer next() {
                return new Customer();
            }
        };
    }

    public static Generator<Customer> newGenerator() {
        return Customer::new;
    }
}


class Teller {
    private static long counter = 1;
    private final long id = counter++;

    private Teller() {
    }

    public String toString() {
        return String.format("Teller %s", id);
    }

    public static Generator<Teller> generator = new Generator<Teller>() {
        @Override public Teller next() {
            return new Teller();
        }
    };

    public static Generator<Teller> newGenerator = Teller::new;
}


public class BankTeller {
    public static void server(Teller teller, Customer customer) {
        System.out.println(String.format("%s serves %s", teller, customer));
    }

    public static void main(String[] args) {
        Random random = new Random(47);
        Queue<Customer> line = new LinkedList<>();
        Generators.fill(line, Customer.newGenerator(), 15);

        List<Teller> tellers = new ArrayList<>();
        Generators.fill(tellers, Teller.newGenerator, 4);

        for (Customer customer : line) {
            server(tellers.get(random.nextInt(tellers.size())), customer);
        }
    }

}
