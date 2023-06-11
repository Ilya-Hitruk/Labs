package hw27.Client;


public interface Clients {

    Client ilya = new Client("Ilya", 101, 4000, GoalOfVisit.WITHDRAW, 10000);
    Client ihor = new Client("Ihor", 102, 5000, GoalOfVisit.DEPOSIT, 40000);
    Client tatiana = new Client("Tatiana", 103, 3000, GoalOfVisit.DEPOSIT, 30000);

    Client leonid = new Client("Leonid", 201, 4500, GoalOfVisit.WITHDRAW, 25000);
    Client oksana = new Client("Oksana", 202, 2000, GoalOfVisit.WITHDRAW, 40000);
    Client vitalii = new Client("Vitalii", 203, 3000, GoalOfVisit.DEPOSIT, 10000);

    Client maxim = new Client("Maxim", 301, 5000, GoalOfVisit.WITHDRAW, 50000);
    Client alice = new Client("Alice", 302, 3000, GoalOfVisit.DEPOSIT, 10000);
    Client ekaterina = new Client("Ekaterina", 303, 2000, GoalOfVisit.WITHDRAW, 45000);
}
