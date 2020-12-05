package operations;

import actions.ActionTypesEnum;
import commons.*;
import devices.*;

import java.util.*;

public class RoutePath {

    static ArrayList<String> finalVisitedNodes = new ArrayList<>();

    public static void findPath(String arguments[]) {
        if (arguments.length == ActionTypesEnum.INFO_ROUTE.getArgumentLength()) {
            NodeList list = NodeList.getInstance();

            if (BasicFunctions.isNodeRouter(arguments[1]) || BasicFunctions.isNodeRouter(arguments[2])) {
                System.out.println(Labels.ROUTE_REPETER);
                return;
            }
            if (BasicFunctions.isNodeComputer(arguments[1]) && BasicFunctions.isNodeComputer(arguments[2])) {
                Computer startNode = list.allComputers.get(arguments[1]);
                Computer endNode = list.allComputers.get(arguments[2]);
                if (startNode.getName() == endNode.getName()) {
                    String path = BasicFunctions.formPath("", startNode.getName());
                    System.out.println(BasicFunctions.formPath(path, endNode.getName()));
                } else {
                    ArrayList<String> visitedNodes = new ArrayList<>();
                    visitedNodes.add(startNode.getName());
                    if (tracePath(startNode, endNode, startNode.getStrength(), visitedNodes)) {
                        System.out.println(BasicFunctions.getRoutePath(finalVisitedNodes));
                    } else {
                        System.out.println(Labels.ROUTE_NOT_FOUND);
                    }
                }
            } else {
                System.out.println(Labels.NODE_NOT_FOUND);
                return;
            }

        } else {
            System.out.println(Labels.INVALID_COMMAND);
        }
    }

    public static boolean tracePath(Object startNode, Computer endNode, int weight, ArrayList<String> visitedNodes) {
        boolean status = false;
        if (startNode instanceof Computer) {
            Computer node = (Computer) startNode;
            if (node.getLinked().connectedComputers.containsKey(endNode.getName())) {
                visitedNodes.add(endNode.getName());
                finalVisitedNodes.clear();
                finalVisitedNodes.addAll(visitedNodes);
                return true;
            } else {
                ConnectedNodes connected = node.getLinked();
                HashMap<String, Computer> connectedComputers = connected.connectedComputers;
                for (Map.Entry<String, Computer> nodeItem : connectedComputers.entrySet()) {

                    if (!(visitedNodes.contains(nodeItem.getValue().getName()))) {
                        int newWeight = weight - 1;
                        ArrayList<String> newVisitedNodes = new ArrayList<>();
                        newVisitedNodes.addAll(visitedNodes);
                        if (newWeight >= 0) {
                            newVisitedNodes.add(nodeItem.getValue().getName());
                            Computer nextNode = nodeItem.getValue();
                            status = tracePath(nextNode, endNode, newWeight, newVisitedNodes);
                            if (status) {
                                return status;
                            }
                        }
                    }

                }

                HashMap<String, Repeter> connectedRepeter = connected.connectedRepeters;
                for (Map.Entry<String, Repeter> nodeItem : connectedRepeter.entrySet()) {
                    if (!(visitedNodes.contains(nodeItem.getValue().getName()))) {
                        int newWeight = weight * 5;
                        ArrayList<String> newVisitedNodes = new ArrayList<>();
                        newVisitedNodes.addAll(visitedNodes);
                        if (newWeight >= 0) {
                            newVisitedNodes.add(nodeItem.getValue().getName());
                            Repeter nextNode = nodeItem.getValue();
                            status = tracePath(nextNode, endNode, newWeight, newVisitedNodes);
                            if (status) {
                                return status;
                            }
                        }
                    }

                }

            }

        } else if (startNode instanceof Repeter) {
            Repeter nodeRepeter = (Repeter) startNode;
            if (nodeRepeter.getLinked().connectedComputers.containsKey(endNode.getName())) {
                visitedNodes.add(endNode.getName());
                finalVisitedNodes.clear();
                finalVisitedNodes.addAll(visitedNodes);
                return true;
            } else {
                ConnectedNodes connected = nodeRepeter.getLinked();
                HashMap<String, Computer> connectedComputers = connected.connectedComputers;
                for (Map.Entry<String, Computer> nodeItem : connectedComputers.entrySet()) {

                    if (!(visitedNodes.contains(nodeItem.getValue().getName()))) {
                        int newWeight = weight - 1;
                        ArrayList<String> newVisitedNodes = new ArrayList<>();
                        newVisitedNodes.addAll(visitedNodes);
                        if (newWeight >= 0) {
                            newVisitedNodes.add(nodeItem.getValue().getName());
                            Computer nextNode = nodeItem.getValue();
                            status = tracePath(nextNode, endNode, newWeight, newVisitedNodes);
                            if (status) {
                                return status;
                            }
                        }
                    }

                }

                HashMap<String, Repeter> connectedRepeter = connected.connectedRepeters;
                for (Map.Entry<String, Repeter> nodeItem : connectedRepeter.entrySet()) {
                    if (!(visitedNodes.contains(nodeItem.getValue().getName()))) {
                        int newWeight = weight * 5;
                        ArrayList<String> newVisitedNodes = new ArrayList<>();
                        newVisitedNodes.addAll(visitedNodes);
                        if (newWeight >= 0) {
                            newVisitedNodes.add(nodeItem.getValue().getName());
                            Repeter nextNode = nodeItem.getValue();
                            status = tracePath(nextNode, endNode, newWeight, newVisitedNodes);
                            if (status) {
                                return status;
                            }
                        }
                    }

                }

            }
        }
        return false;

    }
}
