package covidvis;

import java.awt.Color;
import java.text.DecimalFormat;
import cs2.Button;
import cs2.Shape;
import cs2.TextShape;
import cs2.Window;
import cs2.WindowSide;

/**
 * Visualizes the COVID-19 testing data in a new window.
 * 
 * @author all
 * @version 2020.11.30
 */
public class GUIWindow {
    private Window window;
    private Calculator calc;
    private Button alpha;
    private Button cfr;
    private Button quit;
    private Button[] stateButtons;

    /**
     * Display Window
     */
    public GUIWindow(Calculator calculator) {
        //Setup
        this.calc = calculator;
        this.window = new Window();
        
        //Shapes (Temp Delete Later)
        this.displayState(0);
        
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
        for (State state : this.calc.states()) {
            Button stateName = new Button("Represent " + state.getName());
            this.window.addButton(stateName, WindowSide.SOUTH);
        }
    }

    // TODO Figure out a way to implement clickedState without an int parameter.

    /**
     * Click method for quit button
     * @param button The button clicked
     */
    public void clickedQuit(Button button) {
        System.exit(0);
    }

    public void clickedAlpha(Button alpha) {
        // TODO
    }


    public void clickedCfr(Button cfr) {
        // TODO
    }
    
    public void clickedState(Button state) {
        // TODO
    }

    private void displayState(int index) {
        State state = calc.getStateByIndex(index);
        SinglyLinkedList<EthnicityGroup> list = state.getList();
        int x = this.window.getWidth() / 5;
        int y = this.window.getHeight() / 4;
        TextShape stateName = new TextShape((x * 2)+10, y-80, state.getName() 
            + " Case Fatality Ratios by Race");
        this.window.addShape(stateName);
        for (int i = 0; i < list.size(); i++) {
            displayBar(list.get(i), i+1);
        }
    }

    private void displayBar(EthnicityGroup group, int index) {
        int x = this.window.getWidth() / 5;
        int y = this.window.getHeight() / 4;
        int width = 20;
        int percent = (int)group.getCfr();
        if (percent > 1) {
            Shape groupBar = new Shape(x * index, y+100, width, percent, new Color(0,0,255));
            this.window.addShape(groupBar);
        } else {
            TextShape groupBar = new TextShape(x * index, y+100, "NA", new Color(0,0,255));
            this.window.addShape(groupBar);
        }
        TextShape groupName = new TextShape((x * index)-10, y+120, group.getName());
        this.window.addShape(groupName);
        DecimalFormat formatter = new DecimalFormat("###.#");
        TextShape groupCFR = new TextShape((x * index)-5, y+140, formatter.format(group.getCfr()) + "%");
        this.window.addShape(groupCFR);
    }
}
