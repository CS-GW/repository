public class Item {
    String itemName;
    String itemDescription;

    public enum ItemActions {
        POSSESS,
        SHAKE,
        THROW
    }

    ItemActions[] itemActionsArray;

    public Item(String name, String description, String possibleAction) {
        this.itemName = name;
        this.itemDescription = description;
        this.itemActionsArray = new ItemActions[3];
    }

    public boolean arrayCheck(ItemActions action) {
        for (int i = 0; i < itemActionsArray.length; i++) {
            if (itemActionsArray[i] == action) {
                return true;
            }
        }
        return false;
    }

    public void addItemAction(ItemActions action){
        boolean check = true;
        int counter = 0;

        while(check && counter < 3){
            if (itemActionsArray[counter] == null){
                itemActionsArray[counter] = action;
                check = false;
            } else {
                counter++;
            }
        }
    }

    public boolean arrayCheck1(ItemActions action) {
        for (int i = 0; i < itemActionsArray.length; i++) {

            switch (action) {
                case POSSESS:
                    for (ItemActions local: itemActionsArray){
                        if (local == action){
                            return true;
                        }
                    }
                case THROW:
                    return false;
                case SHAKE:
                    return false;
                default:
                    return true;
            }

        }
        return true;
    }

}







