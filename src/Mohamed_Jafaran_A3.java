//-------------------------------------------------------------------------------
//Name : Mohamed Jafaran Khan
/////UOW NO : 7311448
//Tutorial: T05
//Declaration: I declare that this submission is my own work
//File : MohamedJafaranKhan_A2
//-------------------------------------------------------------------------------
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.*;
import java.util.Collections;
import java. util. Arrays;



class OlympicFrame  extends JFrame
{

    private JButton[] jButtonArray;
    private final String[] countryArray = {"USA", "SPAIN", "CHINA", "JAPAN", "ITALY",
            "GERMANY", "FRANCE", "BRAZIL", "NETHERLAND", "POLAND", "RUSSIA", "UKRAINE"};
    private ArrayList<Olympic> alist = new ArrayList<Olympic>();   // THIS IS ARRAYLIST OF OLYMPIC OBJECTS
    // CREATED BASED ON COUNTRY ARRAY
    Double[] totalscore = new Double[countryArray.length]; // THIS IS AN ARRAY  VERSION OF TOTAL SCORE .
    // YOU can use ARRAYS SORT ON THIS
    double[] totalscore2 = new double[countryArray.length];   // DEEP COPY  BACK INTO ARRAY




    public OlympicFrame()
    {
        super("The Olympic Games 2020");

        setLayout(new GridLayout(4, 3));

        // CONSTRUCT LIST OF COUNTRIES
        constructAlist();

        // CONSTRUCT LIST OF TOTAL SCORES FOR EACH COUNTRY IN ARRAY FORMAT
        for (int i = 0; i < alist.size(); i++) {

            double x = alist.get(i).totalScores();
            totalscore[i] = x;
        }

        // SORT THE SCORE ARRAY IN DESCENDING ORDER

        Arrays.sort(totalscore, Collections.reverseOrder());


        // PERFORM DEEPCOPY INTO AN ARRAY FORMAT
        for (int g = 0; g < totalscore.length; g++) {
            totalscore2[g] = totalscore[g];
        }

        //SET RANK
        for (int g = 0; g < totalscore2.length; g++)
        {
            for(Olympic a : alist)
            {
                if (a.totalScores() == totalscore2[g])
                {
                    a.set(g+1);
                }
            }
        }



        jButtonArray = new JButton[countryArray.length];
        TextFieldhandler ab = new TextFieldhandler();
        for (int k = 0; k < countryArray.length ; k++) {
            Icon image = new ImageIcon("src\\buttons\\" + (k + 1) + ".jpg"); // this brings out the country pic
            // WE WANT TO RESCALE THE IMAGE.
            Image image2 = ((ImageIcon) image).getImage(); // get the image out and put it in image2 variable
            Image newimg = image2.getScaledInstance(150, 130,  java.awt.Image.SCALE_SMOOTH); // scale it
            image = new ImageIcon(newimg); // create new image icon with

            // jbArray[k] = new JButton(countryArray[k],image);
            jButtonArray[k] = new JButton(image);
            jButtonArray [k].setVerticalTextPosition(SwingConstants.BOTTOM);
            add(jButtonArray[k]);

            // Register Action Listener for each button
            jButtonArray[k].addActionListener(ab);//gui
        }

    }

    private void constructAlist()
    {

        for (String x : countryArray) {
            Olympic y = new Olympic(x);
            alist.add(y);
        }

    }

    private class TextFieldhandler implements ActionListener
    {

        @Override
        public void actionPerformed(ActionEvent event)
        {
            int g = 0;
            for (JButton jb : jButtonArray) {
                if (event.getSource() == jb) {
                    Icon podium = new ImageIcon("src\\buttons\\trophy.jpg");//trophy img
                    jb.setText("Rank " + alist.get(g).getRank());//txt in pop up
                    jb.setVerticalTextPosition(SwingConstants.TOP);
                    JOptionPane.showMessageDialog(null, getFinalRanking(), "Olympic 2020"//pop up msg
                            , JOptionPane.PLAIN_MESSAGE, podium);
                }
                g++;
            }

        }
    }

    // TAKES IN THE TOTAL SCORE ARRAY and THE TOTAL SCORE

    private int getRank(double[] scoreArray, double d)
    {



        int rankie = 0;
        for (int a = 0; a < scoreArray.length; a++)
        {
            if(scoreArray[a] == d)
            {
                rankie = a+1;
            }

        }return rankie;

    }

    private String getFinalRanking()
    {


        StringBuffer x = new StringBuffer();
        x.append("Final Ranking");
        x.append(System.lineSeparator());
        int i =1;
        for (Olympic y : alist)
        {


            x.append(System.lineSeparator());
            x.append( "Rank: "   +  getRank(totalscore2,totalscore2[i-1])  + " "
                    + getCountry(alist,i) + " "  + "(" + getScores(alist, getCountry(alist,i)) +")" );
            i++;

        }
        x.append(System.lineSeparator());
        return x.toString();


    }




    private String getCountry(ArrayList<Olympic> alist, int n)
    {

        String Country = "";
        for (Olympic b : alist) {
            for (double d : totalscore2) {
                if (totalscore2[n - 1] == b.totalScores())
                    Country = b.getName();
            }
        }
        return Country;

    }

    double scoreA = 0;

    private double getScores(ArrayList<Olympic> alist, String name)
    {
        // EXACTLY SIMILAR

        double score = 0;
        for (Olympic a : alist) {
            if (a.getName() == name) {
                score = a.totalScores();
            }
        }

        score = Math.round(score*100.0)/100.00;
        return score;
    }
}




class Olympic
{

    private int no = (15);
    private String country;

    private int rank;
    private double[] score;




    // Other Constructor
    Olympic(String country)
    {
        this.country = country;
        score = new double[no];
        processScores();
    }

    // Copy Constructor
    Olympic(Olympic mike)
    {
        this(mike.country);
    }

    // helps to generate scores for each judge
    public void processScores()
    {
        for (int l = 0; l < score.length; l++) {
            score[l] = Math.random() * 100.0;//random score
        }

    }


    public double totalScores()
    {

        double sum = 0;
        for (int i = 0; i < no; i++) {

            sum += score[i];
        }
        return sum;
    }


    public void set(int rank)
    {
        this.rank = rank;
    }


    public int getRank()
    {
        return rank;
    }


    public String getName()
    {
        return country;
    }

    private double[] getScoreArray()
    {
        return score;
    }

    public String toString()
    {
        return String.format("Rank %d : %s (%2.f)%n", getRank(), getName(), totalScores());
    }

}


public class Mohamed_Jafaran_A3
{
    public static void main(String[] args)
    {
        OlympicFrame x = new OlympicFrame();

        x.setSize(900, 700); // EXACTLY SAME
        x.setResizable(true);
        x.setVisible(true);
        x.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }
}