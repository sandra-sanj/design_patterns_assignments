package memento.guistate;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;


public class Controller {
    private Model model;
    private Gui gui;
    private ObservableList<IMemento> undoHistory; // Memento history
    private ObservableList<IMemento> redoHistory;
    private IMemento currentState;

    public Controller(Gui gui) {
        this.model = new Model();
        this.gui = gui;
        this.undoHistory = FXCollections.observableArrayList();
        this.redoHistory = FXCollections.observableArrayList();
    }

    public void setOption(int optionNumber, int choice) {
        saveToHistory();
        model.setOption(optionNumber, choice);
        gui.updateGui();
    }

    public int getOption(int optionNumber) {
        return model.getOption(optionNumber);
    }

    public void setIsSelected(boolean isSelected) {
        saveToHistory();
        model.setIsSelected(isSelected);
        gui.updateGui();
    }

    public boolean getIsSelected() {
        return model.getIsSelected();
    }

    public void undo() {
        if (!undoHistory.isEmpty()) {
            //System.out.println("Memento found in undo history");
            //IMemento currentState = model.createMemento();
            IMemento previousState = undoHistory.remove(undoHistory.size() - 1);
            redoHistory.add(previousState);
            currentState = previousState;
            model.restoreState(previousState);
            gui.updateGui();
        }
    }

    public void redo() {
        if (!redoHistory.isEmpty()) {
            //System.out.println("Memento found in redo history");
            //IMemento currentState = model.createMemento();
            IMemento nextState = redoHistory.remove(redoHistory.size() - 1);
            undoHistory.add(nextState);
            currentState = nextState;
            model.restoreState(nextState);
            gui.updateGui();
        }
    }

    private void saveToHistory() {
        currentState = model.createMemento();
        undoHistory.add(currentState);
        redoHistory.clear();

        //System.out.println("Undo list size: " + undoHistory.size());
        //System.out.println("Redo list size: " + redoHistory.size());
    }

    public ObservableList<IMemento> getUndoHistory() {
        return undoHistory;
    }

    public ObservableList<IMemento> getRedoHistory() {
        return redoHistory;
    }

    public IMemento getCurrentState() {
        return currentState;
    }

    public void restoreModelState(IMemento memento) {
        currentState = memento;
        model.restoreState(memento);
        gui.updateGui();

        while (redoHistory.contains(memento)) {
            IMemento nextState = redoHistory.remove(redoHistory.size() - 1);
            undoHistory.add(nextState);
        }

        while (undoHistory.contains(memento)) {
            IMemento previousState = undoHistory.remove(undoHistory.size() - 1);
            redoHistory.add(previousState);
        }

    }
}
