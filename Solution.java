import java.util.*;

import devices.*;
import actions.*;
import commons.*;
import operations.*;

class Solution {
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            String readline = in.nextLine();
            String[] arguments = readline.trim().split(" ");
            try {
                if (arguments.length > 0) {
                    String command = arguments[0];
                    ActionTypesEnum type = ActionTypesEnum.valueOf(command);
                    switch (type) {
                        case ADD:
                            DeviceStateActions.addToList(arguments);
                            break;
                        case SET_DEVICE_STRENGTH:
                            DeviceStateActions.modifyStrength(arguments);
                            break;
                        case CONNECT:
                            DeviceStateActions.connectNode(arguments);
                            break;
                        case INFO_ROUTE:
                            RoutePath.findPath(arguments);
                            break;
                        default:
                            System.out.println(Labels.INVALID_COMMAND);
                            break;

                    }
                }
            } catch (Exception e) {
                System.out.println(Labels.INVALID_COMMAND);
            }
        }

    }
}