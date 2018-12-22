import model.Client;
import service.ClientService;
import service.repository.ClientDAO;

public class Main2 {
    public static void main(String[] args) throws Exception {
        try (ClientService service = new ClientService("NewSample.db")) {
            ClientDAO dao = service.getDao();
            Client client = dao.get(1);

            client.setFirstName("Vasya");
            client.setLastName("Pupkin");
            dao.saveClient(client);

            System.out.println(client);

        }
    }
}
