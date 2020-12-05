package operations;

import java.util.*;

import actions.*;
import commons.*;
import devices.*;

public class DeviceStateActions {
    public static void addToList(String[] arguments) {
        if (arguments.length == ActionTypesEnum.ADD.getArgumentLength()) {
            NodeList list = NodeList.getInstance();
            DeviceType device = DeviceType.valueOf(arguments[1]);
            switch (device) {
                case COMPUTER:
                    Computer c = new Computer(arguments[2]);
                    if (list.allComputers.containsKey(arguments[2])) {
                        System.out.println(Labels.ALREADY_ADDED);
                    } else {
                        list.allComputers.put(arguments[2], c);
                        System.out.println(Labels.ADD_NODE_SUCCESS);
                    }
                    break;
                case REPEATER:
                    Repeter r = new Repeter(arguments[2]);
                    if (list.allRouters.containsKey(arguments[2])) {
                        System.out.println(Labels.ALREADY_ADDED);
                    } else {
                        list.allRouters.put(arguments[2], r);
                        System.out.println(Labels.ADD_NODE_SUCCESS);
                    }
                    break;
                default:
                    System.out.println(Labels.INVALID_COMMAND);
            }
        } else {
            System.out.println(Labels.INVALID_COMMAND);
        }
    }

    public static void modifyStrength(String[] arguments) {
        if (arguments.length == ActionTypesEnum.SET_DEVICE_STRENGTH.getArgumentLength()) {
            NodeList list = NodeList.getInstance();
            if (list.allComputers.containsKey(arguments[1])) {
                Computer computer = list.allComputers.get(arguments[1]);
                try {
                    int strength = Integer.parseInt(arguments[2]);
                    computer.setStrength(strength);
                    System.out.println(Labels.STRENGTH_DEFINED);
                } catch (Exception e) {
                    System.out.println(Labels.INVALID_COMMAND);
                }
            } else {
                System.out.println(Labels.INVALID_COMMAND);
            }
        } else {
            System.out.println(Labels.INVALID_COMMAND);
        }
    }

    public static void connectNode(String arguments[]) {
        if (arguments.length == ActionTypesEnum.CONNECT.getArgumentLength()) {
            NodeList list = NodeList.getInstance();
            List<Computer> nodeComputer = new ArrayList<>();
            List<Repeter> nodeRouter = new ArrayList<>();
            if (BasicFunctions.isNodeAvailable(arguments[1]) && BasicFunctions.isNodeAvailable(arguments[2])) {
                if (arguments[1].equals(arguments[2])) {
                    System.out.println(Labels.SAME_NODE);
                    return;
                }
                if (BasicFunctions.isNodeComputer(arguments[1])) {
                    nodeComputer.add(list.allComputers.get(arguments[1]));
                } else {
                    nodeRouter.add(list.allRouters.get(arguments[1]));
                }
                if (BasicFunctions.isNodeComputer(arguments[2])) {
                    nodeComputer.add(list.allComputers.get(arguments[2]));
                } else {
                    nodeRouter.add(list.allRouters.get(arguments[2]));
                }

                if (nodeComputer.size() == 2) {
                    Computer node1 = nodeComputer.get(0);
                    Computer node2 = nodeComputer.get(1);

                    if (node1.getLinked().connectedComputers.containsKey(node2.getName())) {
                        System.out.println(Labels.ALREADY_LINKED);
                    } else {
                        node1.getLinked().connectedComputers.put(node2.getName(), node2);
                        node2.getLinked().connectedComputers.put(node1.getName(), node1);
                        System.out.println(Labels.NODE_CONNECTED);

                    }
                } else if (nodeComputer.size() == 1 && nodeRouter.size() == 1) {
                    Computer node1 = nodeComputer.get(0);
                    Repeter node2 = nodeRouter.get(0);
                    if (node1.getLinked().connectedRepeters.containsKey(node2.getName())) {
                        System.out.println(Labels.ALREADY_LINKED);
                    } else {
                        node1.getLinked().connectedRepeters.put(node2.getName(), node2);
                        node2.getLinked().connectedComputers.put(node1.getName(), node1);
                        System.out.println(Labels.NODE_CONNECTED);

                    }
                } else if (nodeRouter.size() == 2) {
                    Repeter node1 = nodeRouter.get(0);
                    Repeter node2 = nodeRouter.get(1);

                    if (node1.getLinked().connectedRepeters.containsKey(node2.getName())) {
                        System.out.println(Labels.ALREADY_LINKED);
                    } else {
                        node1.getLinked().connectedRepeters.put(node2.getName(), node2);
                        node2.getLinked().connectedRepeters.put(node1.getName(), node1);
                        System.out.println(Labels.NODE_CONNECTED);

                    }
                }
            } else {
                System.out.println(Labels.NODE_NOT_FOUND);
            }

        } else {
            System.out.println(Labels.INVALID_COMMAND);
        }
    }

}
