package ca.alidali.javafxtools;

import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.scene.Cursor;
import javafx.scene.Node;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;

/**
 * Container to add nodes with click listener to set active
 *
 * @author Ali Dali
 * @since 13-03-2020
 * @version 0.1
 * @see HBox
 */
public class HBoxContainer extends HBox implements EventHandler<MouseEvent> {

    private int activeChildIndex;
    private Node activeChild;

    public HBoxContainer() {

    }

    public HBoxContainer(double space) {
        this(); // call default constructor
        this.setSpacing(space);
    }

    /**
     * Do NOT use this method directly to add children
     *
     * @return
     */
    @Override
    public ObservableList<Node> getChildren() {
        return super.getChildren();
    }


    public void addChild(Node node) {
        getChildren().add(node);
        node.setOnMouseClicked(this);
        node.setOnMouseEntered(this);
    }

    public void addChildren(Node... nodes) {
        for (Node node :
                nodes) {
            addChild(node);
        }
    }

    public void selectNextChild() {
        nextChild();
        changeActiveChild();
    }

    public void selectPreviousChild() {
        previousChild();
        changeActiveChild();
    }

    public void nextChild() {
        int allChildren = this.getChildren().size() - 1;
        if (activeChildIndex < allChildren)
            activeChild = this.getChildren().get(++activeChildIndex);
    }

    public void previousChild() {
        if (activeChildIndex > 0)
            activeChild = this.getChildren().get(--activeChildIndex);
    }


    public Node getActiveChild() {
        activeChild = getChildren().get(activeChildIndex);
        return activeChild;
    }

    private void changeActiveChild() {
        for (Node child :
                this.getChildren()) {
            child.setStyle("-fx-background-color: transparent;");
        }
        activeChild.setStyle("-fx-background-color: #00ff00; -fx-fill: #00ff00; -fx-text-fill: red;");
    }

    public void setActive(Node node) {
        if (!this.getChildren().contains(node)) return;
        activeChildIndex = getChildren().indexOf(node);
        getActiveChild();
        changeActiveChild();
    }

    public boolean hasMoreChildren() {
        int allChildren = this.getChildren().size() - 1;
        return activeChildIndex != allChildren;
    }



    @Override
    public void handle(MouseEvent event) {
        Node child = (Node) event.getSource();
        if (event.getEventType() == MouseEvent.MOUSE_CLICKED)
            this.setActive(child);
        else if (event.getEventType() == MouseEvent.MOUSE_ENTERED)
            child.setCursor(Cursor.HAND);
    }
}
