package actions;

public enum ActionTypesEnum {
    ADD(3), SET_DEVICE_STRENGTH(3), CONNECT(3), INFO_ROUTE(3);

    private int argumentLength;

    ActionTypesEnum(int length) {
        this.argumentLength = length;
    }

    public int getArgumentLength() {
        return this.argumentLength;
    }
}
