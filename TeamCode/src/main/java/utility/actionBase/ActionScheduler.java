package utility.actionBase;

import java.util.ArrayList;

public class ActionScheduler {
    private final ArrayList<Action> actions = new ArrayList<>();

    void schedule(Action action){
        if (actions.contains(action)) throw new UnsupportedOperationException(
                "Trying to schedule an already scheduled action instance of type " + action.getClass().getName()
        );

        actions.add(action);
    }

    void update(){
        for (Action action : actions){
            if (!action.isStarted()) action.start();

            if (!action.isFinished()) action.update();

            if (action.isFinished()) action.stop();
        }
        actions.removeIf(Action::isFinished);
    }
}
