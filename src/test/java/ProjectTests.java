import com.project.exchange.*;
import org.junit.Test;

import static org.junit.Assert.assertEquals;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * Created by Alex on 19.10.2017.
 */
public class ProjectTests {

    @Test
    public void ClientsManagerTest() {
        ClientsManager clientsManager = new ClientsManager("clients.test.txt");
        TreeMap<String, Clients> clientsMap = clientsManager.getClientsList();

        for (Map.Entry<String, Clients> entry : clientsMap.entrySet()) {
            String[] names = {"A", "B", "C", "D"};
            int[] values = {130, 240, 760, 320};
            assertEquals(entry.getKey(), "C1");
            assertEquals(entry.getValue().getBalance(), 1000);

            HashMap<String, Securities> securitiesHashMap = entry.getValue().getHashMap();

            int i = 0;
            for (Map.Entry<String, Securities> Newentry : securitiesHashMap.entrySet()) {
                assertEquals(names[i], Newentry.getKey());
                assertEquals(values[i], Newentry.getValue().getValue());
                i++;
            }
        }
    }


    @Test
    public void orderManagerTest() {
        OrdersManager ordersManager = new OrdersManager("orders.test.txt");
        ArrayList<Orders> orders = ordersManager.getOrders();

        for (Orders orders1 : orders) {
            assertEquals("C8", orders1.getClientName());
            assertEquals("b", orders1.getTypeOperation());
            assertEquals("C", orders1.getSecuritiesName());
            assertEquals(15, orders1.getCostOneSecurities());
            assertEquals(4, orders1.getValueOneSecurities());
        }
    }

}
