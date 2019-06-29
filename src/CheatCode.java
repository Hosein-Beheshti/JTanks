import javax.swing.*;
import java.awt.*;

/**
 * this class have a textfield and
 * this read your cheat code and ...
 */
public class CheatCode {
    private JTextField code;
    private String codeString;
    private JPanel myPanel;
    private GridLayout layout;

    public CheatCode()
    {

    }

    /**
     * show panel that contain textfield
     * @param state
     */
    public void showPanel(GameState state)
    {
        state.keyC = false;

        myPanel = new JPanel();
        layout = new GridLayout(3, 3, 2, 12);
        myPanel.setLayout(layout);

        code = new JTextField();
        //  address.setText("http://file.all-free-download.com/downloadfiles/graphic/graphic_1/red_business_icons_vector_286626.zip");


        myPanel.add(new JLabel("Cheat Code :"));
        myPanel.add(code);

        int result = JOptionPane.showConfirmDialog(null, myPanel,
                "Please Enter a Cheat code", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);

        if (result == JOptionPane.OK_OPTION) {
           codeString = code.getText();
           if(codeString.equals("repair"))
           {
               state.health = 500;
           }
            if(codeString.equals("heavyBullet"))
            {
                state.numberOfHeavyBullets = state.numberOfHeavyBullets + 50;
            }
            if(codeString.equals("lightBullet"))
            {
                state.numberOfLightBullets = state.numberOfLightBullets + 50;
            }

        }
        }

    }

