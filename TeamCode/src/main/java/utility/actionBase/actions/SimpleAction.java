package utility.actionBase.actions;

import utility.actionBase.AbstractAction;

public class SimpleAction extends AbstractAction {
    private final Runnable action;

    public SimpleAction(Runnable action){
        this.action = action;
    }



    @Override
    public void update(){
        action.run();
        finished = true;
    }


}
