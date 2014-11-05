package test;
//������������ͼƬ������ӡ�£�
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import javax.imageio.ImageIO;

public class ImgGenerator {
    public static void main(String[] args) throws IOException {
        String fileName = "f:/name/names.txt";
        List<String> nameList = readFileByLine(fileName);
        for (int i = 0; i < nameList.size(); i++) {
            generateImg(nameList.get(i));
        }
    }

    public static List<String> readFileByLine(String fileName) throws IOException {
        List<String> nameList = new ArrayList<String>();
        File file = new File(fileName);
        InputStreamReader isr = new InputStreamReader(new FileInputStream(file), "UTF-8");
        BufferedReader reader = new BufferedReader(isr);
        String tmp;
        while ((tmp = reader.readLine()) != null) {
            nameList.add(tmp);
        }
        reader.close();
        return nameList;
    }

    public static void generateImg(String name) throws IOException {
        int width = 100;
        int height = 100;
        String first = null, second = null, third = null, fourth = null;

        first = name.substring(0, 1);
        second = name.substring(1, 2);
        if (name.length() == 2) {
            third = "ӡ";
            fourth = null;
        } else if (name.length() == 3) {
            third = name.substring(2, 3);
            fourth = "ӡ";
        } else {
            third = name.substring(2, 3);
            fourth = name.substring(3, 4);
        }

        String fileName = "f:/name/" + name + ".bmp";
        System.out.println(fileName);

        File file = new File(fileName);
        Font font = new Font("����", Font.PLAIN, 30);

        BufferedImage bi = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        Graphics2D g2 = (Graphics2D) bi.getGraphics();
        g2.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);

        g2.setBackground(getRandomColor());
        g2.clearRect(0, 0, width, height);
        g2.setFont(font);
        g2.setPaint(Color.white);

        g2.drawString(first, 55, 40);
        g2.drawString(second, 55, 80);
        g2.drawString(third, 15, 40);

        if (fourth == null) {
            drawStar(g2);
        } else {
            g2.drawString(fourth, 15, 80);
        }

        ImageIO.write(bi, "bmp", file);
    }

    public static Color getRandomColor() {
        Random r = new Random();
        return new Color(r.nextInt(255), r.nextInt(255), r.nextInt(255));
    }

    public static void drawStar(Graphics2D g) {
        // ��������Բ���ڽ�Բ�İ뾶
        int R = 16;
        int r = (int) (R * Math.sin(Math.PI / 10) / Math.sin(3 * Math.PI / 10));
        // ������������, �ֱ���10�������x, y ����
        int[] x = new int[10];
        int[] y = new int[10];
        // ͨ��ѭ�����������鸳ֵ
        for (int i = 0; i < 10; i++) {
            if (i % 2 == 0) {
                x[i] = 30 + (int) (R * Math.cos(Math.PI / 10 + (i - 1) * Math.PI / 5));
                y[i] = 70 + (int) (R * Math.sin(Math.PI / 10 + (i - 1) * Math.PI / 5));
            } else {
                x[i] = 30 + (int) (r * Math.cos(Math.PI / 10 + (i - 1) * Math.PI / 5));
                y[i] = 70 + (int) (r * Math.sin(Math.PI / 10 + (i - 1) * Math.PI / 5));
            }
        }

        g.setPaint(Color.white);
        // ����fillPolygon��������
        g.fillPolygon(x, y, 10);
    }
}
