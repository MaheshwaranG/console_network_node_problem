package commons;

import java.util.ArrayList;

public class BasicFunctions {
    public static boolean isNodeAvailable(String name) {
        NodeList list = NodeList.getInstance();
        return list.allComputers.containsKey(name) || list.allRouters.containsKey(name);
    }

    public static boolean isNodeComputer(String name) {
        NodeList list = NodeList.getInstance();
        return list.allComputers.containsKey(name);
    }

    public static boolean isNodeRouter(String name) {
        NodeList list = NodeList.getInstance();
        return list.allRouters.containsKey(name);
    }

    public static String formPath(String path, String node) {
        if (path.isEmpty()) {
            return node;
        }
        return path + Labels.PATH_FLOW + node;
    }

    public static String getRoutePath(ArrayList<String> nodes) {
        String path = "";
        for (String node : nodes) {
            path = formPath(path, node);
        }
        return path;
    }
}
