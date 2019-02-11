package procesodigitalimagenes;

import java.awt.Color;
import java.awt.Font;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;
import javax.swing.text.BadLocationException;
import javax.swing.text.DefaultStyledDocument;
import javax.swing.text.Style;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyleContext;


public class FiltrosLetras {

    ImageIcon Seleccion;
    BufferedImage imagen;


    public void seleccionarImagen(String img){
        try{
            imagen = ImageIO.read(new File(img));
            Seleccion = new ImageIcon(imagen);
            System.out.println("Se seleccionó la imagen:" + img);
        }catch (IOException e) {
            e.printStackTrace();
        }
    }

    public int promedioRegion(int inicioa, int fina,int iniciol, int finl, BufferedImage img){
        int rp =0;
        int gp =0;
        int bp =0;
        int cantidad = (img.getHeight() / 90)*(img.getWidth() /90) ;
        for(int a = inicioa ; a < fina;a++){
            for(int b= iniciol;b< finl;b++){
             if(a<img.getWidth()){
               if(b<img.getHeight()){
                  Color c1=new Color(img.getRGB(a, b));
                  rp+= c1.getRed();
                  gp+= c1.getGreen();
                  bp+= c1.getBlue();
               }
             }
            }
        }
        rp = (int)(rp/cantidad);
        gp = (int)(gp/cantidad);
        bp = (int)(bp/cantidad);
        int promedio = (int)((rp + gp + bp)/3);
        return promedio;
    }

    public Color promedioRegion(int inicioa, int fina,int iniciol, int finl, BufferedImage img, Boolean f){
        int rp =0;
        int gp =0;
        int bp =0;
        int cantidad = (img.getHeight() / 90)*(img.getWidth() /90) ;
        for(int a = inicioa ; a < fina;a++){
            for(int b= iniciol;b< finl;b++){
             if(a<img.getWidth()){
               if(b<img.getHeight()){
                  Color c1=new Color(img.getRGB(a, b));
                  rp+= c1.getRed();
                  gp+= c1.getGreen();
                  bp+= c1.getBlue();
               }
             }
            }
        }
        rp = (int)(rp/cantidad);
        gp = (int)(gp/cantidad);
        bp = (int)(bp/cantidad);
        return new Color(rp,gp,bp);
    }


    public String filtroDomino(String img){
    SeleccionarImagen(img);
    int a =  imagen.getHeight() / 90;
    int l = imagen.getWidth() / 90;
    String s = "";
    if(imagen != null){
        for (int y = 0; y < 90; y++){
            if(y > 0) s += "\n";
            for (int x = 0 ; x < 90; x++){
                int med= PromedioRegion(x*l,(x*l)+l,y*a,(y*a)+a,imagen);
                if (med >= 0 && med < 37){
                    s += "6";
                } else if(med >= 37 && med < 74){
                    s += "5";
                }else if(med >= 74 && med < 111){
                    s += "4";
                }else if(med >= 111 && med < 148){
                    s += "3";
                }else if(med >= 148 && med < 185){
                    s += "2";
                }else if(med >= 185 && med < 222){
                    s += "1";
                }else if(med >= 222 && med < 256){
                    s += "0";
                }
            }
        }
    }
    return s;
 }
    /**
    * Método que traduce cada pixel a una cadena de sec
    * sec debe estar ordenada de la cadena mas oscura a la mas clara
    * @param img - la imagen a procesar
    * @param sec - el arreglo de cadenas por las que se va a reemplazar cada región
    * @param x - tamaño horizontal de la región
    * @param y - tamaño vartical de la región
    * @return String - Representa la imagen al ser procesada 
    */
    public String f0(BufferedImage img, String[] sec, int x, int y){
        String s = "";
        for (int j=0; j<imagen.getHeight()/y; j++){
            for (int i=0; i<imagen.getWidth()/x; i++){
                for (int k=i*x; k<i*x+x; k++){
                    for (int m=j*y; m<; m++){
                    }
                    s += "\n";
                }
            }
            s += "\n";
        }
        return s;
    }


    public String filtroCadena(String img){
    SeleccionarImagen(img);
    int a =  imagen.getHeight() / 90;
    int l = imagen.getWidth() / 90;
    String s = "";
    if(imagen != null){
        for (int y = 0; y < 90; y++){
            if(y > 0) s += "\n";
            for (int x = 0 ; x < 90; x++){
                int med= PromedioRegion(x*l,(x*l)+l,y*a,(y*a)+a,imagen);
                if (med >= 0 && med < 16){
                    s += "M";
                } else if(med >= 16 && med < 32){
                    s += "N";
                }else if(med >= 32 && med < 48){
                    s += "H";
                }else if(med >= 48 && med < 64){
                    s += "#";
                }else if(med >= 64 && med < 80){
                    s += "Q";
                }else if(med >= 80 && med < 96){
                    s += "U";
                }else if(med >= 96 && med < 112){
                    s += "A";
                }else if(med >= 112 && med < 128){
                    s += "D";
                }else if(med >= 128 && med < 144){
                    s += "O";
                }else if(med >= 144 && med < 160){
                    s += "Y";
                }else if(med >= 160 && med < 176){
                    s += "2";
                }else if(med >= 176 && med < 192){
                    s += "$";
                }else if(med >= 192 && med < 208){
                    s += "%";
                }else if(med >= 208 && med < 224){
                    s += "+";
                }else if(med >= 224 && med < 240){
                    s += "_";
                }else if(med >= 240 && med < 256){
                    s += " ";
                }

            }
        }
    }
    return s;
 }



    public String filtroCartas(String img){
    SeleccionarImagen(img);
    int a =  imagen.getHeight() / 90;
    int l = imagen.getWidth() / 90;
    String s = "";
    if(imagen != null){
        for (int y = 0; y < 90; y++){
            if(y > 0) s += "\n";
            for (int x = 0 ; x < 90; x++){
                int med= PromedioRegion(x*l,(x*l)+l,y*a,(y*a)+a,imagen);
                if (med >= 0 && med < 23){
                    s += "Z";
                } else if(med >= 23 && med < 46){
                    s += "W";
                }else if(med >= 46 && med < 69){
                    s += "V";
                }else if(med >= 69 && med < 92){
                    s += "U";
                }else if(med >= 92 && med < 115){
                    s += "T";
                }else if(med >= 115 && med < 138){
                    s += "S";
                }else if(med >= 138 && med < 161){
                    s += "R";
                }else if(med >= 161 && med < 184){
                    s += "Q";
                }else if(med >= 184 && med < 207){
                    s += "P";
                }else if(med >= 207 && med < 230){
                    s += "O";
                }else if(med >= 230 && med < 256){
                    s += "N";
                }
            }
        }
    }
    return s;
 }

 public void filtroUnaLetra(String img) throws BadLocationException{
    SeleccionarImagen(img);
    int a =  imagen.getHeight() / 90;
    int l = imagen.getWidth() / 90;
    String s = "";
    if(imagen != null){
        for (int y = 0; y < 90; y++){
            if(y > 0) s += "\n";
            for (int x = 0 ; x < 90; x++){
                s += "@";
            }
        }
    }

    StyleContext sc = new StyleContext();
    DefaultStyledDocument doc = new DefaultStyledDocument(sc);
    JTextPane pane = new JTextPane(doc);

    JFrame f = new JFrame("Filtro Una sola Letra,Color");
    doc.insertString(0, s, null);

   // Style estilo = sc.addStyle("ConstantWidth", null);
    Color c = new Color(0,0,0);
    int contador = 0;
    for (int h = 0; h < 90; h++){
            if(h > 0) contador++ ;
            for (int k = 0 ; k < 90; k++){
                Style estilo = sc.addStyle("ConstantWidth", null);
                c = PromedioRegion(k*l,(k*l)+l,h*a,(h*a)+a,imagen,false);
                StyleConstants.setForeground(estilo, c);
                doc.setCharacterAttributes(contador++, 1, estilo, false);
            }
        }
    f.getContentPane().add(new JScrollPane(pane));
    f.setSize(1300, 600);
    f.setVisible(true);
    //return pane;
 }


 public void filtroUnaLetraBN(String img) throws BadLocationException{
    SeleccionarImagen(img);
    int a =  imagen.getHeight() / 90;
    int l = imagen.getWidth() / 90;
    String s = "";
    if(imagen != null){
        for (int y = 0; y < 90; y++){
            if(y > 0) s += "\n";
            for (int x = 0 ; x < 90; x++){
                s += "@";
            }
        }
    }

    StyleContext sc = new StyleContext();
    DefaultStyledDocument doc = new DefaultStyledDocument(sc);
    JTextPane pane = new JTextPane(doc);

    JFrame f = new JFrame("Filtro Una sola Letra, Grises");
    doc.insertString(0, s, null);

   // Style estilo = sc.addStyle("ConstantWidth", null);
    Color c = new Color(0,0,0);
    int prom = 0;
    int contador = 0;
    for (int h = 0; h < 90; h++){
            if(h > 0) contador++ ;
            for (int k = 0 ; k < 90; k++){
                Style estilo = sc.addStyle("ConstantWidth", null);
                c = PromedioRegion(k*l,(k*l)+l,h*a,(h*a)+a,imagen,false);
                prom = (c.getRed() + c.getGreen() + c.getBlue())/3;
                StyleConstants.setForeground(estilo, new Color(prom,prom,prom));
                doc.setCharacterAttributes(contador++, 1, estilo, false);
            }
        }
    f.getContentPane().add(new JScrollPane(pane));
    f.setSize(1300, 600);
    f.setVisible(true);
    //return pane;
 }


 public void filtroTexto(String img, String texto) throws BadLocationException{
    SeleccionarImagen(img);
    int a =  imagen.getHeight() / 90;
    int l = imagen.getWidth() / 90;
    int aux = 0;
    String s = "";
    if(imagen != null){
        for (int y = 0; y < 90; y++){
            if(y > 0) s += "\n";
            for (int x = 0 ; x < 90; x++){
                if(aux == texto.length()){
                    s += " ";
                    aux = 0;
                } else{
                    s += texto.substring(aux, aux+1);
                    aux++;
                }
            }
        }
    }

    StyleContext sc = new StyleContext();
    DefaultStyledDocument doc = new DefaultStyledDocument(sc);
    JTextPane pane = new JTextPane(doc);

    JFrame f = new JFrame("Filtro Texto con Color");
    doc.insertString(0, s, null);

   // Style estilo = sc.addStyle("ConstantWidth", null);
    Color c = new Color(0,0,0);
    int contador = 0;
    for (int h = 0; h < 90; h++){
            if(h > 0) contador++ ;
            for (int k = 0 ; k < 90; k++){
                Style estilo = sc.addStyle("ConstantWidth", null);
                c = PromedioRegion(k*l,(k*l)+l,h*a,(h*a)+a,imagen,false);
                StyleConstants.setForeground(estilo, c);
                doc.setCharacterAttributes(contador++, 1, estilo, false);
            }
        }
    pane.setFont(new Font("Courier New", Font.PLAIN, 18));
    f.getContentPane().add(new JScrollPane(pane));
    f.setSize(1300, 600);
    f.setVisible(true);
    //return pane;
 }



}