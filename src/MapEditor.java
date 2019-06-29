import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

public class MapEditor {
    private JFrame mapEditor;
    private JPanel buttonsPanel;
    private JTextArea textArea;
    private JButton addToFilter;
    private JButton editMap;
    private JButton okEditButton;
    private File file;
    private int sizeX;
    private int sizeY;
    private char[][] map;
    private int i,j,k = 0,l = 0,m = 0,n = 0;
    private static boolean done = true;

    /**
     * constructor for FilterAddress clas
     */

    public MapEditor() {

        GameFrame.getStartGame().mapEditor = false;
        mapEditor = new JFrame("Map Editor");
        BorderLayout layout = new BorderLayout();
        mapEditor.setLayout(layout);
        mapEditor.setSize(400, 800);
        mapEditor.setLocation(GameFrame.GAME_WIDTH / 2 - 250 , GameFrame.GAME_HEIGHT / 2 - 350);

        textArea = new JTextArea();
        JScrollPane scrollPane = new JScrollPane(textArea);
        mapEditor.add(scrollPane, BorderLayout.CENTER);
        editMap = new JButton("Edit");
        done = false;
        editMap.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {


                File file = new File("./maps/myMap.txt");
                FileReader reader = null;
                try {
                    reader = new FileReader(file);
                } catch (FileNotFoundException e1) {
                    e1.printStackTrace();
                }
                BufferedReader bufferedReader = new BufferedReader(reader);
                bufferedReader.lines().forEach(data -> textArea.setText(textArea.getText() + data + "\n"));
            }
        });
        okEditButton = new JButton("Ok");
        okEditButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                File file = new File("./maps/myMap.txt");
                try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
                    writer.append(textArea.getText());
                   // bw.newLine();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
                Map.setStage1(false);
                Map.setStage2(false);
                Map.setStage3(false);
                Map.setMyMapBool(true);
                done = true;
            }
        });
        buttonsPanel = new JPanel();
        buttonsPanel.add(editMap);
        buttonsPanel.add(okEditButton);
        mapEditor.add(buttonsPanel, BorderLayout.SOUTH);
        mapEditor.setVisible(true);
    }
    public static boolean isDone() {
        return done;
    }
}
