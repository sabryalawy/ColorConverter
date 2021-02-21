/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package colorconverter;

import java.awt.AWTException;
import java.awt.Color;
import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.PointerInfo;
import java.awt.Robot;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.control.Alert;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Paint;

/**
 * FXML Controller class
 *
 * @author Alawi
 */
public class HomeController implements Initializable {

    Robot r;
    Color c;
    

    @FXML
    private Pane colorPane;
    @FXML
    private TextField redTX;

    @FXML
    private TextField cyanTX;

    @FXML
    private TextField saturationTX;

    @FXML
    private ImageView yao;

    @FXML
    private Slider blueSD;

    @FXML
    private Slider valueSD;

    @FXML
    private TextField hueTX;

    @FXML
    private TextField yellowTX;

    @FXML
    private Slider magentaSD;

    @FXML
    private TextField greenTX;

    @FXML
    private Slider yellowSD;

    @FXML
    private Slider saturationSD;

    @FXML
    private Slider cyanSD;

    @FXML
    private Slider redSD;

    @FXML
    private Slider hueSD;

    @FXML
    private TextField magentaTX;

    @FXML
    private TextField valueTX;

    @FXML
    private Slider greenSD;

    @FXML
    private TextField blueTX;

    // the image clickable ______________________________________________________________________________________________________
    @FXML
    void yyyyaaa(MouseEvent event) throws AWTException {
        PointerInfo po = MouseInfo.getPointerInfo();
        Point p = po.getLocation();
        r = new Robot();
        c = r.getPixelColor((int) p.getX(), (int) p.getY());
        //for RGB ________________________________________________________
        redSD.setValue(c.getRed());
        blueSD.setValue(c.getBlue());
        greenSD.setValue(c.getGreen());
        redTX.setText("" + c.getRed());
        blueTX.setText("" + c.getBlue());
        greenTX.setText("" + c.getGreen());

        //for CMY___________________________________________________________
        cyanSD.setValue(RGBtoCMYandBack(c.getRed()));
        magentaSD.setValue(RGBtoCMYandBack(c.getGreen()));
        yellowSD.setValue(RGBtoCMYandBack(c.getBlue()));
        cyanTX.setText("" + RGBtoCMYandBack(c.getRed()));
        magentaTX.setText("" + RGBtoCMYandBack(c.getGreen()));
        yellowTX.setText("" + RGBtoCMYandBack(c.getBlue()));
        colorPane.setBackground(new Background(new BackgroundFill(Paint.valueOf(RGBToHexColor(c.getRed(), c.getGreen(), c.getBlue())), CornerRadii.EMPTY, Insets.EMPTY)));
        //for HSV___________________________________________________________
        hueSD.setValue(HueCalculationFromRGB((int) redSD.getValue(), (int) greenSD.getValue(), (int) blueSD.getValue()));
        hueTX.setText("" + HueCalculationFromRGB((int) redSD.getValue(), (int) greenSD.getValue(), (int) blueSD.getValue()));
        saturationSD.setValue(SaturationCalculationFormRGB((int) redSD.getValue(), (int) greenSD.getValue(), (int) blueSD.getValue()));
        saturationTX.setText(SaturationCalculationFormRGB((int) redSD.getValue(), (int) greenSD.getValue(), (int) blueSD.getValue()) + "");
        valueSD.setValue(ValueCalculationFormRGB((int) redSD.getValue(), (int) greenSD.getValue(), (int) blueSD.getValue()));
        valueTX.setText(ValueCalculationFormRGB((int) redSD.getValue(), (int) greenSD.getValue(), (int) blueSD.getValue()) + "");
    }

    //RBG slider and text________________________________________________________________________________________________________________________
    @FXML
    void redSDcat(Event event) {
        SliderEditerRGB(redTX, redSD);
        cyanSD.setValue(RGBtoCMYandBack(Integer.valueOf(redTX.getText())));
        cyanTX.setText("" + RGBtoCMYandBack(Integer.valueOf(redTX.getText())));
        hueSD.setValue(HueCalculationFromRGB((int) redSD.getValue(), (int) greenSD.getValue(), (int) blueSD.getValue()));
        hueTX.setText("" + HueCalculationFromRGB((int) redSD.getValue(), (int) greenSD.getValue(), (int) blueSD.getValue()));
        saturationSD.setValue(SaturationCalculationFormRGB((int) redSD.getValue(), (int) greenSD.getValue(), (int) blueSD.getValue()));
        saturationTX.setText(SaturationCalculationFormRGB((int) redSD.getValue(), (int) greenSD.getValue(), (int) blueSD.getValue()) + "");
        valueSD.setValue(ValueCalculationFormRGB((int) redSD.getValue(), (int) greenSD.getValue(), (int) blueSD.getValue()));
        valueTX.setText(ValueCalculationFormRGB((int) redSD.getValue(), (int) greenSD.getValue(), (int) blueSD.getValue()) + "");
    }

    @FXML
    void greenSDact(MouseEvent event) {
        SliderEditerRGB(greenTX, greenSD);
        magentaSD.setValue(RGBtoCMYandBack(Integer.valueOf(greenTX.getText())));
        magentaTX.setText("" + RGBtoCMYandBack(Integer.valueOf(greenTX.getText())));
        hueSD.setValue(HueCalculationFromRGB((int) redSD.getValue(), (int) greenSD.getValue(), (int) blueSD.getValue()));
        hueTX.setText("" + HueCalculationFromRGB((int) redSD.getValue(), (int) greenSD.getValue(), (int) blueSD.getValue()));
        saturationSD.setValue(SaturationCalculationFormRGB((int) redSD.getValue(), (int) greenSD.getValue(), (int) blueSD.getValue()));
        saturationTX.setText(SaturationCalculationFormRGB((int) redSD.getValue(), (int) greenSD.getValue(), (int) blueSD.getValue()) + "");
        valueSD.setValue(ValueCalculationFormRGB((int) redSD.getValue(), (int) greenSD.getValue(), (int) blueSD.getValue()));
        valueTX.setText(ValueCalculationFormRGB((int) redSD.getValue(), (int) greenSD.getValue(), (int) blueSD.getValue()) + "");
    }

    @FXML
    void blueSDact(Event event) {
        SliderEditerRGB(blueTX, blueSD);
        yellowSD.setValue(RGBtoCMYandBack(Integer.valueOf(blueTX.getText())));
        yellowTX.setText("" + RGBtoCMYandBack(Integer.valueOf(blueTX.getText())));
        hueSD.setValue(HueCalculationFromRGB((int) redSD.getValue(), (int) greenSD.getValue(), (int) blueSD.getValue()));
        hueTX.setText("" + HueCalculationFromRGB((int) redSD.getValue(), (int) greenSD.getValue(), (int) blueSD.getValue()));
        saturationSD.setValue(SaturationCalculationFormRGB((int) redSD.getValue(), (int) greenSD.getValue(), (int) blueSD.getValue()));
        saturationTX.setText(SaturationCalculationFormRGB((int) redSD.getValue(), (int) greenSD.getValue(), (int) blueSD.getValue()) + "");
        valueSD.setValue(ValueCalculationFormRGB((int) redSD.getValue(), (int) greenSD.getValue(), (int) blueSD.getValue()));
        valueTX.setText(ValueCalculationFormRGB((int) redSD.getValue(), (int) greenSD.getValue(), (int) blueSD.getValue()) + "");
    }

    @FXML
    void redTXact(KeyEvent event) {
        TextEditerRGB(redTX, redSD);
        cyanSD.setValue(RGBtoCMYandBack(Integer.valueOf(redTX.getText())));
        cyanTX.setText("" + RGBtoCMYandBack(Integer.valueOf(redTX.getText())));
        hueSD.setValue(HueCalculationFromRGB((int) redSD.getValue(), (int) greenSD.getValue(), (int) blueSD.getValue()));
        hueTX.setText("" + HueCalculationFromRGB((int) redSD.getValue(), (int) greenSD.getValue(), (int) blueSD.getValue()));
        saturationSD.setValue(SaturationCalculationFormRGB((int) redSD.getValue(), (int) greenSD.getValue(), (int) blueSD.getValue()));
        saturationTX.setText(SaturationCalculationFormRGB((int) redSD.getValue(), (int) greenSD.getValue(), (int) blueSD.getValue()) + "");
        valueSD.setValue(ValueCalculationFormRGB((int) redSD.getValue(), (int) greenSD.getValue(), (int) blueSD.getValue()));
        valueTX.setText(ValueCalculationFormRGB((int) redSD.getValue(), (int) greenSD.getValue(), (int) blueSD.getValue()) + "");
    }

    @FXML
    void greenTXact(KeyEvent event) {
        TextEditerRGB(greenTX, greenSD);
        magentaSD.setValue(RGBtoCMYandBack(Integer.valueOf(greenTX.getText())));
        magentaTX.setText("" + RGBtoCMYandBack(Integer.valueOf(greenTX.getText())));
        hueSD.setValue(HueCalculationFromRGB((int) redSD.getValue(), (int) greenSD.getValue(), (int) blueSD.getValue()));
        hueTX.setText("" + HueCalculationFromRGB((int) redSD.getValue(), (int) greenSD.getValue(), (int) blueSD.getValue()));
        saturationSD.setValue(SaturationCalculationFormRGB((int) redSD.getValue(), (int) greenSD.getValue(), (int) blueSD.getValue()));
        saturationTX.setText(SaturationCalculationFormRGB((int) redSD.getValue(), (int) greenSD.getValue(), (int) blueSD.getValue()) + "");
        valueSD.setValue(ValueCalculationFormRGB((int) redSD.getValue(), (int) greenSD.getValue(), (int) blueSD.getValue()));
        valueTX.setText(ValueCalculationFormRGB((int) redSD.getValue(), (int) greenSD.getValue(), (int) blueSD.getValue()) + "");
    }

    @FXML
    void blueTXact(KeyEvent event) {
        TextEditerRGB(blueTX, blueSD);
        yellowSD.setValue(RGBtoCMYandBack(Integer.valueOf(blueTX.getText())));
        yellowTX.setText("" + RGBtoCMYandBack(Integer.valueOf(blueTX.getText())));
        hueSD.setValue(HueCalculationFromRGB((int) redSD.getValue(), (int) greenSD.getValue(), (int) blueSD.getValue()));
        hueTX.setText("" + HueCalculationFromRGB((int) redSD.getValue(), (int) greenSD.getValue(), (int) blueSD.getValue()));
        saturationSD.setValue(SaturationCalculationFormRGB((int) redSD.getValue(), (int) greenSD.getValue(), (int) blueSD.getValue()));
        saturationTX.setText(SaturationCalculationFormRGB((int) redSD.getValue(), (int) greenSD.getValue(), (int) blueSD.getValue()) + "");
        valueSD.setValue(ValueCalculationFormRGB((int) redSD.getValue(), (int) greenSD.getValue(), (int) blueSD.getValue()));
        valueTX.setText(ValueCalculationFormRGB((int) redSD.getValue(), (int) greenSD.getValue(), (int) blueSD.getValue()) + "");
    }
    //CMY slider and text________________________________________________________________________________________________________________________

    @FXML
    void yellowSDact(Event event) {
        SliderEditerCMY(yellowTX, yellowSD);
        blueSD.setValue(RGBtoCMYandBack(Integer.valueOf(yellowTX.getText())));
        blueTX.setText("" + RGBtoCMYandBack(Integer.valueOf(yellowTX.getText())));
        hueSD.setValue(HueCalculationFromRGB((int) redSD.getValue(), (int) greenSD.getValue(), (int) blueSD.getValue()));
        hueTX.setText("" + HueCalculationFromRGB((int) redSD.getValue(), (int) greenSD.getValue(), (int) blueSD.getValue()));
        saturationSD.setValue(SaturationCalculationFormRGB((int) redSD.getValue(), (int) greenSD.getValue(), (int) blueSD.getValue()));
        saturationTX.setText(SaturationCalculationFormRGB((int) redSD.getValue(), (int) greenSD.getValue(), (int) blueSD.getValue()) + "");
        valueSD.setValue(ValueCalculationFormRGB((int) redSD.getValue(), (int) greenSD.getValue(), (int) blueSD.getValue()));
        valueTX.setText(ValueCalculationFormRGB((int) redSD.getValue(), (int) greenSD.getValue(), (int) blueSD.getValue()) + "");
    }

    @FXML
    void magentaSDact(Event event) {
        SliderEditerCMY(magentaTX, magentaSD);
        greenSD.setValue(RGBtoCMYandBack(Integer.valueOf(magentaTX.getText())));
        greenTX.setText("" + RGBtoCMYandBack(Integer.valueOf(magentaTX.getText())));
        hueSD.setValue(HueCalculationFromRGB((int) redSD.getValue(), (int) greenSD.getValue(), (int) blueSD.getValue()));
        hueTX.setText("" + HueCalculationFromRGB((int) redSD.getValue(), (int) greenSD.getValue(), (int) blueSD.getValue()));
        saturationSD.setValue(SaturationCalculationFormRGB((int) redSD.getValue(), (int) greenSD.getValue(), (int) blueSD.getValue()));
        saturationTX.setText(SaturationCalculationFormRGB((int) redSD.getValue(), (int) greenSD.getValue(), (int) blueSD.getValue()) + "");
        valueSD.setValue(ValueCalculationFormRGB((int) redSD.getValue(), (int) greenSD.getValue(), (int) blueSD.getValue()));
        valueTX.setText(ValueCalculationFormRGB((int) redSD.getValue(), (int) greenSD.getValue(), (int) blueSD.getValue()) + "");
    }

    @FXML
    void cyanSDact(Event event) {
        SliderEditerCMY(cyanTX, cyanSD);
        redSD.setValue(RGBtoCMYandBack(Integer.valueOf(cyanTX.getText())));
        redTX.setText("" + RGBtoCMYandBack(Integer.valueOf(cyanTX.getText())));
        hueSD.setValue(HueCalculationFromRGB((int) redSD.getValue(), (int) greenSD.getValue(), (int) blueSD.getValue()));
        hueTX.setText("" + HueCalculationFromRGB((int) redSD.getValue(), (int) greenSD.getValue(), (int) blueSD.getValue()));
        saturationSD.setValue(SaturationCalculationFormRGB((int) redSD.getValue(), (int) greenSD.getValue(), (int) blueSD.getValue()));
        saturationTX.setText(SaturationCalculationFormRGB((int) redSD.getValue(), (int) greenSD.getValue(), (int) blueSD.getValue()) + "");
        valueSD.setValue(ValueCalculationFormRGB((int) redSD.getValue(), (int) greenSD.getValue(), (int) blueSD.getValue()));
        valueTX.setText(ValueCalculationFormRGB((int) redSD.getValue(), (int) greenSD.getValue(), (int) blueSD.getValue()) + "");
    }

    @FXML
    void cyanTXact(KeyEvent event) {
        TextEditerCMY(cyanTX, cyanSD);
        redSD.setValue(RGBtoCMYandBack(Integer.valueOf(cyanTX.getText())));
        redTX.setText("" + RGBtoCMYandBack(Integer.valueOf(cyanTX.getText())));
        hueSD.setValue(HueCalculationFromRGB((int) redSD.getValue(), (int) greenSD.getValue(), (int) blueSD.getValue()));
        hueTX.setText("" + HueCalculationFromRGB((int) redSD.getValue(), (int) greenSD.getValue(), (int) blueSD.getValue()));
        saturationSD.setValue(SaturationCalculationFormRGB((int) redSD.getValue(), (int) greenSD.getValue(), (int) blueSD.getValue()));
        saturationTX.setText(SaturationCalculationFormRGB((int) redSD.getValue(), (int) greenSD.getValue(), (int) blueSD.getValue()) + "");
        valueSD.setValue(ValueCalculationFormRGB((int) redSD.getValue(), (int) greenSD.getValue(), (int) blueSD.getValue()));
        valueTX.setText(ValueCalculationFormRGB((int) redSD.getValue(), (int) greenSD.getValue(), (int) blueSD.getValue()) + "");
    }

    @FXML
    void magentaTXact(KeyEvent event) {
        TextEditerCMY(magentaTX, magentaSD);
        greenSD.setValue(RGBtoCMYandBack(Integer.valueOf(magentaTX.getText())));
        greenTX.setText("" + RGBtoCMYandBack(Integer.valueOf(magentaTX.getText())));
        hueSD.setValue(HueCalculationFromRGB((int) redSD.getValue(), (int) greenSD.getValue(), (int) blueSD.getValue()));
        hueTX.setText("" + HueCalculationFromRGB((int) redSD.getValue(), (int) greenSD.getValue(), (int) blueSD.getValue()));
        saturationSD.setValue(SaturationCalculationFormRGB((int) redSD.getValue(), (int) greenSD.getValue(), (int) blueSD.getValue()));
        saturationTX.setText(SaturationCalculationFormRGB((int) redSD.getValue(), (int) greenSD.getValue(), (int) blueSD.getValue()) + "");
        valueSD.setValue(ValueCalculationFormRGB((int) redSD.getValue(), (int) greenSD.getValue(), (int) blueSD.getValue()));
        valueTX.setText(ValueCalculationFormRGB((int) redSD.getValue(), (int) greenSD.getValue(), (int) blueSD.getValue()) + "");
    }

    @FXML
    void yellowTXact(KeyEvent event) {
        TextEditerCMY(yellowTX, yellowSD);
        blueSD.setValue(RGBtoCMYandBack(Integer.valueOf(yellowTX.getText())));
        blueTX.setText("" + RGBtoCMYandBack(Integer.valueOf(yellowTX.getText())));
        hueSD.setValue(HueCalculationFromRGB((int) redSD.getValue(), (int) greenSD.getValue(), (int) blueSD.getValue()));
        hueTX.setText("" + HueCalculationFromRGB((int) redSD.getValue(), (int) greenSD.getValue(), (int) blueSD.getValue()));
        saturationSD.setValue(SaturationCalculationFormRGB((int) redSD.getValue(), (int) greenSD.getValue(), (int) blueSD.getValue()));
        saturationTX.setText(SaturationCalculationFormRGB((int) redSD.getValue(), (int) greenSD.getValue(), (int) blueSD.getValue()) + "");
        valueSD.setValue(ValueCalculationFormRGB((int) redSD.getValue(), (int) greenSD.getValue(), (int) blueSD.getValue()));
        valueTX.setText(ValueCalculationFormRGB((int) redSD.getValue(), (int) greenSD.getValue(), (int) blueSD.getValue()) + "");
    }

    //HSV slider and text________________________________________________________________________________________________________________________
    @FXML
    void valueSDact(Event event) {
        SliderEditerHSV(valueTX, valueSD);
    }

    @FXML
    void saturationSDact(Event event) {
        SliderEditerHSV(saturationTX, saturationSD);
    }

    @FXML
    void hueSDact(Event event) {
        try {
            hueTX.setText("" + (Math.round(100 * hueSD.getValue()) / 100.0));

            int[] rez = RGBFromHSV(hueSD.getValue(), Double.valueOf(saturationTX.getText()), Double.valueOf(valueTX.getText()));
            colorPane.setBackground(new Background(new BackgroundFill(Paint.valueOf(RGBToHexColor(rez[0], rez[1], rez[2])), CornerRadii.EMPTY, Insets.EMPTY)));
            redSD.setValue(rez[0]);
            redTX.setText("" + rez[0]);
            greenSD.setValue(rez[1]);
            greenTX.setText("" + rez[1]);
            blueSD.setValue(rez[2]);
            blueTX.setText("" + rez[2]);

            cyanSD.setValue(255 - rez[0]);
            cyanTX.setText("" + (255 - rez[0]));
            magentaSD.setValue(255 - rez[1]);
            magentaTX.setText("" + (255 - rez[1]));
            yellowSD.setValue(255 - rez[2]);
            yellowTX.setText("" + (255 - rez[2]));
        } catch (Exception e) {

        }
    }

    @FXML
    void valueTXact(KeyEvent event) {
        TextEditerHSV(valueTX, valueSD);
    }

    @FXML
    void saturationTXact(KeyEvent event) {
        TextEditerHSV(saturationTX, saturationSD);
    }

    @FXML
    void hueTXact(KeyEvent event) {
        try {
            int[] rez = RGBFromHSV(Double.valueOf(hueTX.getText()), Double.valueOf(saturationTX.getText()), Double.valueOf(valueTX.getText()));

            if (Double.valueOf(hueTX.getText()) < 360) {
                hueSD.setValue(Double.valueOf(hueTX.getText()));
                colorPane.setBackground(new Background(new BackgroundFill(Paint.valueOf(RGBToHexColor(rez[0], rez[1], rez[2])), CornerRadii.EMPTY, Insets.EMPTY)));
                redSD.setValue(rez[0]);
                redTX.setText("" + rez[0]);
                greenSD.setValue(rez[1]);
                greenTX.setText("" + rez[1]);
                blueSD.setValue(rez[2]);
                blueTX.setText("" + rez[2]);

                cyanSD.setValue(255 - rez[0]);
                cyanTX.setText("" + (255 - rez[0]));
                magentaSD.setValue(255 - rez[1]);
                magentaTX.setText("" + (255 - rez[1]));
                yellowSD.setValue(255 - rez[2]);
                yellowTX.setText("" + (255 - rez[2]));
            } else {
                Alert a = new Alert(Alert.AlertType.ERROR);
                a.setTitle("ERROR");
                a.setContentText("make sure that the number you enter is less than 360 .");
                a.show();
                hueTX.setText("359");
                hueSD.setValue(359);
            }
        } catch (Exception e) {
            Alert a = new Alert(Alert.AlertType.ERROR);
            a.setTitle("ERROR");
            a.setContentText(e.getMessage());
            a.show();
            hueTX.setText("0");
        }

    }

    // first excuted_______________________________________________________________________________________________
    @Override
    public void initialize(URL url, ResourceBundle rb) {

        //started value for RGB_______________________
        redSD.setMin(0);
        redSD.setMax(255);

        blueSD.setMin(0);
        blueSD.setMax(255);

        greenSD.setMin(0);
        greenSD.setMax(255);

        redTX.setText("0");
        greenTX.setText("0");
        blueTX.setText("0");

        // started value for CMY_______________________
        cyanSD.setMin(0);
        cyanSD.setMax(255);

        magentaSD.setMin(0);
        magentaSD.setMax(255);

        yellowSD.setMin(0);
        yellowSD.setMax(255);

        cyanTX.setText("255");
        magentaTX.setText("255");
        yellowTX.setText("255");

        cyanSD.setValue(255);
        magentaSD.setValue(255);
        yellowSD.setValue(255);

        // started value for HSV_______________________
        hueSD.setMin(0.0);
        hueSD.setMax(359);
        hueSD.setValue(0);

        saturationSD.setMin(0);
        saturationSD.setMax(100);
        saturationSD.setValue(0);

        valueSD.setMin(0);
        valueSD.setMax(100);
        valueSD.setValue(0);

        hueTX.setText("0.0");
        saturationTX.setText("0");
        valueTX.setText("0");

        colorPane.setBackground(new Background(new BackgroundFill(Paint.valueOf("#000000"), CornerRadii.EMPTY, Insets.EMPTY)));
    }

    // RGB functions for set on act and convert and more __________________________________________________________________________________________________
    public void TextEditerRGB(TextField tx, Slider sd) {
        try {
            if (Double.valueOf(tx.getText()) < 256) {
                sd.setValue(Double.valueOf(tx.getText()));
                colorPane.setBackground(new Background(new BackgroundFill(Paint.valueOf(RGBToHexColor(Integer.valueOf(redTX.getText()), Integer.valueOf(greenTX.getText()), Integer.valueOf(blueTX.getText()))), CornerRadii.EMPTY, Insets.EMPTY)));

            } else {
                Alert a = new Alert(Alert.AlertType.ERROR);
                a.setTitle("ERROR");
                a.setContentText("make sure that the number you enter is less than 256.");
                a.show();
                tx.setText("255");
                sd.setValue(255);
            }
        } catch (Exception e) {
            Alert a = new Alert(Alert.AlertType.ERROR);
            a.setTitle("ERROR");
            a.setContentText(e.toString());
            a.show();
            tx.setText("0");
        }
    }

    public void SliderEditerRGB(TextField tx, Slider sd) {
        try {
            tx.setText((int) sd.getValue() + "");
            colorPane.setBackground(new Background(new BackgroundFill(Paint.valueOf(RGBToHexColor(Integer.valueOf(redTX.getText()), Integer.valueOf(greenTX.getText()), Integer.valueOf(blueTX.getText()))), CornerRadii.EMPTY, Insets.EMPTY)));
        } catch (Exception e) {

        }
    }

    public int[] RGBFromHSV(double hl, double sl, double vl) {
        double s = sl / 100.0;
        double v = vl / 100.0;

        int[] rez = new int[3];

        double mid = 0.0, high = 0.0, low = 0.0, alpha = 0.0;
        int ih;

        high = v;
        low = high * (1 - s);

        ih = (int) Math.floor((hl / 60.0));

        alpha = (hl / 60.0) - ih;

        if (ih % 2 != 0) {
            alpha = 1 - alpha;
        }

        mid = low + (alpha * (high - low));
        switch (ih) {
            case 0:
                rez[0] = (int) (high * 255.0);
                rez[1] = (int) (mid * 255.0);
                rez[2] = (int) (low * 255.0);
                break;
            case 1:
                rez[0] = (int) (mid * 255.0);
                rez[1] = (int) (high * 255.0);
                rez[2] = (int) (low * 255.0);
                break;
            case 2:
                rez[0] = (int) (low * 255.0);
                rez[1] = (int) (high * 255.0);
                rez[2] = (int) (mid * 255.0);
                break;
            case 3:
                rez[0] = (int) (low * 255.0);
                rez[1] = (int) (mid * 255.0);
                rez[2] = (int) (high * 255.0);
                break;
            case 4:
                rez[0] = (int) (mid * 255.0);
                rez[1] = (int) (low * 255.0);
                rez[2] = (int) (high * 255.0);
                break;
            case 5:
                rez[0] = (int) (high * 255.0);
                rez[1] = (int) (low * 255.0);
                rez[2] = (int) (mid * 255.0);
                break;
        }
        return rez;
    }
    // CMY functions  for set on sct snd convert and more _____________________________________________________________________________________________

    public int RGBtoCMYandBack(int i) {
        return 255 - i;
    }

    public void TextEditerCMY(TextField tx, Slider sd) {
        try {
            if (Double.valueOf(tx.getText()) < 256) {
                sd.setValue(Double.valueOf(tx.getText()));
                colorPane.setBackground(new Background(new BackgroundFill(Paint.valueOf(RGBToHexColor(RGBtoCMYandBack(Integer.valueOf(cyanTX.getText())), RGBtoCMYandBack(Integer.valueOf(magentaTX.getText())), RGBtoCMYandBack(Integer.valueOf(yellowTX.getText())))), CornerRadii.EMPTY, Insets.EMPTY)));
            } else {
                Alert a = new Alert(Alert.AlertType.ERROR);
                a.setTitle("ERROR");
                a.setContentText("make sure that the number you enter is less than is less than 256.");
                a.show();
                tx.setText("255");
                sd.setValue(255);
            }
        } catch (Exception e) {
            Alert a = new Alert(Alert.AlertType.ERROR);
            a.setTitle("ERROR");
            a.setContentText("ther is some thing wronge");
            a.show();
            tx.setText("0");
        }
    }

    public void SliderEditerCMY(TextField tx, Slider sd) {
        try {
            tx.setText((int) sd.getValue() + "");
            colorPane.setBackground(new Background(new BackgroundFill(Paint.valueOf(RGBToHexColor(RGBtoCMYandBack(Integer.valueOf(cyanTX.getText())), RGBtoCMYandBack(Integer.valueOf(magentaTX.getText())), RGBtoCMYandBack(Integer.valueOf(yellowTX.getText())))), CornerRadii.EMPTY, Insets.EMPTY)));
        } catch (Exception e) {

        }
    }

    // HSV functions  for set on sct snd convert and more _____________________________________________________________________________________________
    public double HueCalculationFromRGB(int r, int g, int b) {
        double finalrez = 0.0;

        double rTo1 = r / 255.0;
        
        double bTo1 = b / 255.0;
        double gTo1 = g / 255.0;

        double maxIs = Math.max(rTo1, bTo1);
        maxIs = Math.max(maxIs, gTo1);

        double minIs = Math.min(gTo1, rTo1);
        minIs = Math.min(minIs, bTo1);

        if (maxIs == minIs) {
            return 0.0;
        }
        if (rTo1 == maxIs) {
            return (60 * ((gTo1 - bTo1) / (maxIs - minIs)) + 360) % 360;
        }
        if (gTo1 == maxIs) {
            return (60 * ((bTo1 - rTo1) / (maxIs - minIs)) + 120) % 360;
        } else {
            return (60 * ((rTo1 - gTo1) / (maxIs - minIs)) + 240) % 360;
        }
    }

    public double SaturationCalculationFormRGB(int r, int g, int b) {
        double rTo1 = r / 255.0;
        double gTo1 = g / 255.0;
        double bTo1 = b / 255.0;

        double maxIs = Math.max(rTo1, bTo1);
        maxIs = Math.max(maxIs, gTo1);

        double minIs = Math.min(rTo1, bTo1);
        minIs = Math.min(minIs, gTo1);

        if (maxIs == 0) {
            return 0;
        }
        return Math.round(100.0 * ((maxIs - minIs) / maxIs) * 100) / 100.0;

    }

    public double ValueCalculationFormRGB(int r, int g, int b) {
        double rTo1 = r / 255.0;
        double gTo1 = g / 255.0;
        double bTo1 = b / 255.0;

        double maxIs = Math.max(rTo1, bTo1);
        maxIs = Math.max(maxIs, gTo1);
        return Math.round(100.0 * maxIs * 100) / 100.0;
    }

    public void TextEditerHSV(TextField tx, Slider sd) {
        try {
            int[] rez = RGBFromHSV(Double.valueOf(hueTX.getText()), Double.valueOf(saturationTX.getText()), Double.valueOf(valueTX.getText()));

            if (Double.valueOf(tx.getText()) <= 100) {
                sd.setValue(Double.valueOf(tx.getText()));
                colorPane.setBackground(new Background(new BackgroundFill(Paint.valueOf(RGBToHexColor(rez[0], rez[1], rez[2])), CornerRadii.EMPTY, Insets.EMPTY)));
                redSD.setValue(rez[0]);
                redTX.setText("" + rez[0]);
                greenSD.setValue(rez[1]);
                greenTX.setText("" + rez[1]);
                blueSD.setValue(rez[2]);
                blueTX.setText("" + rez[2]);

                cyanSD.setValue(255 - rez[0]);
                cyanTX.setText("" + (255 - rez[0]));
                magentaSD.setValue(255 - rez[1]);
                magentaTX.setText("" + (255 - rez[1]));
                yellowSD.setValue(255 - rez[2]);
                yellowTX.setText("" + (255 - rez[2]));
            } else {
                Alert a = new Alert(Alert.AlertType.ERROR);
                a.setTitle("ERROR");
                a.setContentText("make sure that the number you enter is less than 100 .");
                a.show();
                tx.setText("100");
                sd.setValue(100);
            }
        } catch (Exception e) {
            Alert a = new Alert(Alert.AlertType.ERROR);
            a.setTitle("ERROR");
            a.setContentText(e.toString());
            a.show();
            tx.setText("0");
        }
    }

    public void SliderEditerHSV(TextField tx, Slider sd) {
        try {
            tx.setText((int) sd.getValue() + "");
            int[] rez = RGBFromHSV(Double.valueOf(hueTX.getText()), Double.valueOf(saturationTX.getText()), Double.valueOf(valueTX.getText()));

            colorPane.setBackground(new Background(new BackgroundFill(Paint.valueOf(RGBToHexColor(rez[0], rez[1], rez[2])), CornerRadii.EMPTY, Insets.EMPTY)));
            redSD.setValue(rez[0]);
            redTX.setText("" + rez[0]);
            greenSD.setValue(rez[1]);
            greenTX.setText("" + rez[1]);
            blueSD.setValue(rez[2]);
            blueTX.setText("" + rez[2]);

            cyanSD.setValue(255 - rez[0]);
            cyanTX.setText("" + (255 - rez[0]));
            magentaSD.setValue(255 - rez[1]);
            magentaTX.setText("" + (255 - rez[1]));
            yellowSD.setValue(255 - rez[2]);
            yellowTX.setText("" + (255 - rez[2]));

        } catch (Exception e) {

        }
    }

    //for convert from RGB to HexColor_______________________________________________________________________________________________
    public String RGBToHexColor(int r, int g, int b) {
        return "#" + DecToHex(r) + DecToHex(g) + DecToHex(b);
    }

    public String DecToHex(int dec) {
        int reman = 0;
        String hex = "";
        if (dec > 16) {
            for (int i = 0; i < 2; i++) {
                reman = dec % 16;
                dec = dec / 16;
                hex = trans(reman) + hex;
            }
        } else {
            for (int i = 0; i < 2; i++) {
                reman = dec % 16;
                dec = dec / 16;
                hex = trans(reman) + hex;
            }
        }
        return hex;

    }

    private String trans(int reman) {
        if (reman == 10) {
            return "a";
        }
        if (reman == 11) {
            return "b";
        }
        if (reman == 12) {
            return "c";
        }
        if (reman == 13) {
            return "d";
        }
        if (reman == 14) {
            return "e";
        }
        if (reman == 15) {
            return "f";
        } else {
            return "" + reman;
        }
    }
}
