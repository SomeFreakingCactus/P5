package covidvis;

import java.awt.Color;
import java.text.DecimalFormat;
import java.util.Iterator;
import cs2.Button;
import cs2.Shape;
import cs2.TextShape;
import cs2.Window;
import cs2.WindowSide;

/**
 * Visualizes the COVID-19 testing data in a new window.
 * 
 * @author Noah Coyle (noahcoyle11)
 * @version 11/30/2020
 */
public class GUIWindow {
    private Window window;
    private Calculator calc;
    private Button alpha;
    private Button cfr;
    private Button quit;
    private Button[] stateButtons;

    /**
     * GUI Window
     */
    public GUIWindow(Calculator calculator) {
        //Setup
        this.calc = calculator;
        this.window = new Window();
        this.stateButtons = new Button[6];
        
        //Alpha Button
        this.alpha = new Button("Sort by Alpha");
        this.window.addButton(this.alpha, WindowSide.NORTH);
        this.alpha.onClick(this, "clickedAlpha");
        //Quit Button
        this.quit = new Button("Quit");
        this.window.addButton(this.quit, WindowSide.NORTH);
        this.quit.onClick(this, "clickedQuit");
        //CFR Button
        this.cfr = new Button("Sort by CFR");
        this.window.addButton(this.cfr, WindowSide.NORTH);
        this.cfr.onClick(this, "clickedCfr");
        //States Buttons
        int counter = 0;
        for (State state : this.calc.states()) {
            Button stateName = new Button("Represent " + state.getName());
            this.window.addButton(stateName, WindowSide.SOUTH);
            this.stateButtons[counter] = stateName;
            stateName.onClick(this, "clickedState");
            counter = counter + 1;
        }
        
        ///Default Desplay
        this.displayState(0);
    }

    /**
     * Click method for quit button
     * @param button The button clicked
     */
    public void clickedQuit(Button button) {
        System.exit(0);
    }

    /**
     * Click method for alpah sort button
     * @param button The alpha sort button clicked
     */
    public void clickedAlpha(Button alpha) {
        Iterator<Shape> iter = this.window.getShapesIterator();
        String currentTitle = ((TextShape)iter.next()).getText()
            .replaceAll(" Case Fatality Ratios by Race", "");
        State state = null;
        for (int i = 0; i < this.stateButtons.length; i++) {
            State stateName = calc.getStateByIndex(i);
            String buttonTitle = currentTitle;
            if (buttonTitle.equals(stateName.getName())) {
                state = calc.getStateByIndex(i);
            }
        }
        this.window.removeAllShapes();
        state.sortAlpha();
        SinglyLinkedList<EthnicityGroup> list = state.getList();
        int x = (this.window.getWidth()-126) / 5;
        int y = this.window.getHeight() / 4;
        TextShape stateName = new TextShape((x * 2)+10, y-80, state.getName()
            + " Case Fatality Ratios by Race");
        this.window.addShape(stateName);
        for (int i = 0; i < list.size(); i++) {
            displayBar(list.get(i), i+1);
        }
    }

    /**
     * Click method for cfr sort button
     * @param button The cfr sort clicked
     */
    public void clickedCfr(Button cfr) {
        Iterator<Shape> iter = this.window.getShapesIterator();
        String currentTitle = ((TextShape)iter.next()).getText()
            .replaceAll(" Case Fatality Ratios by Race", "");
        State state = null;
        for (int i = 0; i < this.stateButtons.length; i++) {
            State stateName = calc.getStateByIndex(i);
            String buttonTitle = currentTitle;
            if (buttonTitle.equals(stateName.getName())) {
                state = calc.getStateByIndex(i);
            }
        }
        this.window.removeAllShapes();
        state.sortCFR();
        SinglyLinkedList<EthnicityGroup> list = state.getList();
        int x = (this.window.getWidth()-126) / 5;
        int y = this.window.getHeight() / 4;
        TextShape stateName = new TextShape((x * 2)+10, y-80, state.getName()
            + " Case Fatality Ratios by Race");
        this.window.addShape(stateName);
        for (int i = 0; i < list.size(); i++) {
            displayBar(list.get(i), i+1);
        }
    }
    
    /**
     * Click method for state button
     * @param button The state button clicked
     */
    public void clickedState(Button state) {
        this.window.removeAllShapes();
        for (int i = 0; i < this.stateButtons.length; i++) {
            State stateName = calc.getStateByIndex(i);
            String buttonTitle = state.getTitle().replaceAll("Represent ", "");
            if (buttonTitle.equals(stateName.getName())) {
                this.displayState(i);
            }
        }
    }

    /**
     * Display method for a state
     * @param index The index of the state
     */
    private void displayState(int index) {
        State state = calc.getStateByIndex(index);
        SinglyLinkedList<EthnicityGroup> list = state.getList();
        int x = (this.window.getWidth()-126) / 5;
        int y = this.window.getHeight() / 4;
        TextShape stateName = new TextShape((x * 2)+10, y-80, state.getName()
            + " Case Fatality Ratios by Race");
        this.window.addShape(stateName);
        for (int i = 0; i < list.size(); i++) {
            displayBar(list.get(i), i+1);
        }
    }

    /**
     * Display method for each ethnic group
     * @param group The ethnic group
     * @param index The index of the ethnic group
     */
    private void displayBar(EthnicityGroup group, int index) {
        int x = (this.window.getWidth()-126) / 5;
        int y = this.window.getHeight() / 4;
        int width = 20;
        int percent = (int)(group.getCfr()*10);
        if (percent > -1) {
            Shape groupBar = new Shape(x * index, (y+110)-percent, width, 
                percent, new Color(0,0,255));
            this.window.addShape(groupBar);
        } else {
            TextShape groupBar = new TextShape(x * index, (y+90)-percent, 
                "NA", new Color(0,0,255));
            this.window.addShape(groupBar);
        }
        TextShape groupName = new TextShape((x * index)-10, y+120, 
            group.getName());
        this.window.addShape(groupName);
        DecimalFormat formatter = new DecimalFormat("###.#");
        TextShape groupCFR = new TextShape((x * index)-4, y+140, 
            formatter.format(group.getCfr()) + "%");
        this.window.addShape(groupCFR);
    }
}
