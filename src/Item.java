public class Item {
    String itemName;
    String itemDescription;

    public enum ItemActions {
        POSSESS,
        SHAKE,
        THROW
    }

    ItemActions[] itemActionsArray;

    public Item(String name, String description) {
        this.itemName = name;
        this.itemDescription = description;
        this.itemActionsArray = new ItemActions[3];
    }
    public boolean arrayCheck(ItemActions action) {
        for (int i = 0; i < itemActionsArray.length; i++) {
            if (itemActionsArray[i] == action) {
                return false;
            }
        }
        return true;
    }

    public void addItemAction(ItemActions action){
        if(arrayCheck(action) == true){
            for (int i = 0; i < 3; i++){
                if( itemActionsArray[i] == null){
                    itemActionsArray[i] = action;
                    break;
                    //add without break
                }
            }
        }

    }

    public boolean arrayCheck1(ItemActions action) {
        for (int i = 0; i < itemActionsArray.length; i++) {

            switch (action) {
                case POSSESS:
                    return false;
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







