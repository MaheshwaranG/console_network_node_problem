package commons;

import devices.*;
import java.util.*;

public class NodeList {
    public HashMap<String, Computer> allComputers = new HashMap<>();
    public HashMap<String, Repeter> allRouters = new HashMap<>();
    private static NodeList instance = null;

    private NodeList() {

    }

    public static NodeList getInstance() {
        if (Objects.isNull(instance)) {
            instance = new NodeList();
        }
        return instance;
    }
}
