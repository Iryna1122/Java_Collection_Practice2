import java.util.PriorityQueue;
import java.util.LinkedList;

public class ClientServerRequests {

    static public  class ServerQueue{

        private PriorityQueue<Client> queue;
        private LinkedList<Request> requestStatus;

        public ServerQueue()
        {
            queue=new PriorityQueue<>();
            requestStatus=new LinkedList<>();
        }

        public void addClient(Client client)
        {
            queue.add(client);
        }

        public Client processNextClient()
        {
            Client client = queue.poll();

            if(client != null)
            {
                Request request = new Request(client.getName(), System.currentTimeMillis());
                requestStatus.add(request);
            }
            return client;
        }
        public void displayRequestStatus()
        {
            System.out.println("Statistic: ");

            for(Request req : requestStatus)
            {
                System.out.println("Client: " + req.getUsername());
            }
        }
    }

    public static void main(String[] args) {

        ServerQueue serverQueue = new ServerQueue();

        serverQueue.addClient(new Client("user1",3));
        serverQueue.addClient(new Client("user2",1));
        serverQueue.addClient(new Client("user3",2));

        Client nextClient = serverQueue.processNextClient();

        while(nextClient != null)
        {
            System.out.println("Obrobka client: " + nextClient.getName());
            nextClient = serverQueue.processNextClient();
        }

        serverQueue.displayRequestStatus();
    }


    private static class Client implements Comparable<Client> {
        private String name;
        private int priority;

        public Client(String name, int priority) {
            this.name = name;
            this.priority = priority;
        }

        public String getName() {
            return name;
        }

        public int getPriority() {
            return priority;
        }

        @Override
        public int compareTo(Client other) {

            return Integer.compare(this.priority, other.priority);
        }
    }

    private static class Request {
        private String username;
        private long time;

        public Request(String username, long time) {
            this.username = username;
            this.time = time;
        }

        public String getUsername() {
            return username;
        }

        public long getTime() {
            return time;
        }
    }
}


