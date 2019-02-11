//
//import tarea1.Filtrador;


import java.awt.image.*;
import java.io.*;
import javax.imageio.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;


public class App {
    static BufferedImage imagen;
    static JLabel plImg = new JLabel();
    static ImageIcon ic = new ImageIcon();

    static JSlider getSlider(final JOptionPane optionPane) {
    JSlider slider = new JSlider(0,255, 255);
    slider.setMajorTickSpacing(34);
    slider.setPaintTicks(true);
    slider.setPaintLabels(true);
    ChangeListener changeListener = new ChangeListener() {
      public void stateChanged(ChangeEvent changeEvent) {
        JSlider theSlider = (JSlider) changeEvent.getSource();
        if (!theSlider.getValueIsAdjusting()) {
          optionPane.setInputValue(new Integer(theSlider.getValue()));
        }
      }
    };
    slider.addChangeListener(changeListener);
    return slider;
  }


 
    private static void createGUI(){
        JFrame jf = new JFrame("Felipinho");
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //JLabel emptyLabel = new JLabel("");
        //BufferedImage imagen=null;
        JMenuBar menu = new JMenuBar();
        JMenu archivo = new JMenu("Archivo");

        //Filtrador fil = new Filtrador();
        //Escritor escritor = new Escritor();

        JMenuItem abrir = new JMenuItem(new AbstractAction("Abrir"){
            @Override public void actionPerformed(ActionEvent e){
                JFileChooser fc = new JFileChooser();
                int rv = fc.showOpenDialog(null);
                if(rv == JFileChooser.APPROVE_OPTION){
                    //System.out.print("YES!");

                    File file = fc.getSelectedFile();
                    
                    //abrirImagen(file, imagen);
                    try{
                        imagen = ImageIO.read(file);
                        //fil.setImg(imagen);
                        AlgNaipes a = new AlgNaipes();
                        System.print(a.FiltroCadena(imagen));
                        ic.setImage(imagen);
                        plImg.setIcon(ic);
                        jf.getContentPane().add(plImg);

                        jf.pack();
                        jf.setVisible(true);

                    }catch(Exception ex){

                    }
                }
            }
        });

        
        

        JMenuItem guardar = new JMenuItem(new AbstractAction("Guardar"){
            @Override public void actionPerformed(ActionEvent e){
                JFileChooser fc = new JFileChooser();
                //javax.swing.filechooser.FileFilter ff = new javax.swing.filechooser.FileNameExtensionFilter("JPG Image", "jpg");
                //fc.setFileFilter(ff);
                int rv = fc.showSaveDialog(null);
                if(rv==JFileChooser.APPROVE_OPTION && imagen!=null){
                    File fs = fc.getSelectedFile();
                    String filePath = fs.getAbsolutePath();
                    if(!filePath.endsWith(".png")) {
                        fs = new File(filePath + ".png");
                    }
                    try{
                        ImageIO.write(imagen, "png", fs);
                    }catch (Exception ex) {
                        
                    }
                }
            }
        });

		JMenuItem aplicar = new JMenuItem(new AbstractAction("Aplicar"){
            @Override public void actionPerformed(ActionEvent e){
                JFileChooser fc = new JFileChooser();
                if(imagen==null){
                	return;
                }
                
            }
        });

        archivo.add(abrir);
        archivo.add(guardar);
        menu.add(archivo);
/*
        JMenu filtros = new JMenu("Filtros Color");
        JMenu filtros2 = new JMenu("Filtros Convolucion");
        JMenu procesos = new JMenu("Imagenes con letras");
        JMenu marca = new JMenu("Marca de Agua");
        JMenu recursivas = new JMenu("Imagenes recursivas");
        JMenu ffusion = new JMenu("Fusion");
        JMenu dithering = new JMenu("Dithering");

        JMenuItem aleatorio = new JMenuItem(new AbstractAction("Aleatorio"){
            @Override public void actionPerformed(ActionEvent e){
                if(imagen!=null){
                    imagen = fil.filtrar(15, 0, 0, 0);
                    ic.setImage(imagen);
                    
                    plImg.revalidate();
                    plImg.repaint();
                    //jf.setVisible(true);
                }

            }
        });
        ///////////////////////////////////////////////////////////////////////
        JMenuItem mica = new JMenuItem(new AbstractAction("Mica RGB"){
            @Override public void actionPerformed(ActionEvent e){
                if(imagen!=null){
                    int r,g,b;
                    JOptionPane op = new JOptionPane();
                    JSlider sliderR = getSlider(op);
                    JSlider sliderG = getSlider(op);
                    JSlider sliderB = getSlider(op);

                    op.setMessage(new Object[] { "Select a value: ", sliderR, sliderG, sliderB });
                    op.setMessageType(JOptionPane.QUESTION_MESSAGE);
                    op.setOptionType(JOptionPane.OK_CANCEL_OPTION);
                    JDialog dialog = op.createDialog(jf, "Mica RGB");
                    dialog.setVisible(true);

                    r = sliderR.getValue();
                    g = sliderG.getValue();
                    b = sliderB.getValue();

                    imagen = fil.filtrar(34, r, g, b);
                    ic.setImage(imagen);
                    
                    plImg.revalidate();
                    plImg.repaint();
                    dialog.setVisible(false);
                }

            }
        });

        JMenuItem rojo = new JMenuItem(new AbstractAction("Rojo"){
            @Override public void actionPerformed(ActionEvent e){
                if(imagen!=null){
                    imagen = fil.filtrar(0, 0, 0, 0);
                    ic.setImage(imagen);
                    
                    plImg.revalidate();
                    plImg.repaint();
                    //jf.setVisible(true);
                }

            }
        });
        JMenuItem verde = new JMenuItem(new AbstractAction("Verde"){
            @Override public void actionPerformed(ActionEvent e){
                if(imagen!=null){
                    imagen = fil.filtrar(1, 0, 0, 0);
                    ic.setImage(imagen);
                    
                    plImg.revalidate();
                    plImg.repaint();
                    //jf.setVisible(true);
                }

            }
        });
        JMenuItem azul = new JMenuItem(new AbstractAction("Azul"){
            @Override public void actionPerformed(ActionEvent e){
                if(imagen!=null){
                    imagen = fil.filtrar(2, 0, 0, 0);
                    ic.setImage(imagen);
                    
                    plImg.revalidate();
                    plImg.repaint();
                    //jf.setVisible(true);
                }

            }
        });
        JMenuItem verde_azul = new JMenuItem(new AbstractAction("Verde-Azul"){
            @Override public void actionPerformed(ActionEvent e){
                if(imagen!=null){
                    imagen = fil.filtrar(3, 0, 0, 0);
                    ic.setImage(imagen);
                    
                    plImg.revalidate();
                    plImg.repaint();
                    //jf.setVisible(true);
                }

            }
        });
        JMenuItem rojo_azul = new JMenuItem(new AbstractAction("Rojo-Azul"){
            @Override public void actionPerformed(ActionEvent e){
                if(imagen!=null){
                    imagen = fil.filtrar(4, 0, 0, 0);
                    ic.setImage(imagen);
                    
                    plImg.revalidate();
                    plImg.repaint();
                    //jf.setVisible(true);
                }

            }
        });
        JMenuItem rojo_verde = new JMenuItem(new AbstractAction("Rojo-Verde"){
            @Override public void actionPerformed(ActionEvent e){
                if(imagen!=null){
                    imagen = fil.filtrar(5, 0, 0, 0);
                    ic.setImage(imagen);
                    
                    plImg.revalidate();
                    plImg.repaint();
                    //jf.setVisible(true);
                }

            }
        });
        JMenuItem escala_gris_media = new JMenuItem(new AbstractAction("Escala de grises (Media)"){
            @Override public void actionPerformed(ActionEvent e){
                if(imagen!=null){
                    imagen = fil.filtrar(6, 0, 0, 0);
                    ic.setImage(imagen);
                    
                    plImg.revalidate();
                    plImg.repaint();
                    //jf.setVisible(true);
                }

            }
        });
        JMenuItem escala_gris_rojo = new JMenuItem(new AbstractAction("Escala de grises (Rojo)"){
            @Override public void actionPerformed(ActionEvent e){
                if(imagen!=null){
                    imagen = fil.filtrar(7, 0, 0, 0);
                    ic.setImage(imagen);
                    
                    plImg.revalidate();
                    plImg.repaint();
                    //jf.setVisible(true);
                }

            }
        });
        JMenuItem escala_gris_verde = new JMenuItem(new AbstractAction("Escala de grises (Verde)"){
            @Override public void actionPerformed(ActionEvent e){
                if(imagen!=null){
                    imagen = fil.filtrar(8, 0, 0, 0);
                    ic.setImage(imagen);
                    
                    plImg.revalidate();
                    plImg.repaint();
                    //jf.setVisible(true);
                }

            }
        });
        JMenuItem escala_gris_azul = new JMenuItem(new AbstractAction("Escala de grises (Azul)"){
            @Override public void actionPerformed(ActionEvent e){
                if(imagen!=null){
                    imagen = fil.filtrar(9, 0, 0, 0);
                    ic.setImage(imagen);
                    
                    plImg.revalidate();
                    plImg.repaint();
                    //jf.setVisible(true);
                }

            }
        });
        JMenuItem escala_gris_fix = new JMenuItem(new AbstractAction("Escala de grises (Luma)"){
            @Override public void actionPerformed(ActionEvent e){
                if(imagen!=null){
                    imagen = fil.filtrar(10, 0, 0, 0);
                    ic.setImage(imagen);
                    
                    plImg.revalidate();
                    plImg.repaint();
                    //jf.setVisible(true);
                }

            }
        });
        JMenuItem contraste = new JMenuItem(new AbstractAction("Alto contraste"){
            @Override public void actionPerformed(ActionEvent e){
                if(imagen!=null){
                    imagen = fil.filtrar(11, 0, 0, 0);
                    ic.setImage(imagen);
                    
                    plImg.revalidate();
                    plImg.repaint();
                    //jf.setVisible(true);
                }

            }
        });
        JMenuItem contraste_inv = new JMenuItem(new AbstractAction("Alto contraste (Inverso)"){
            @Override public void actionPerformed(ActionEvent e){
                if(imagen!=null){
                    imagen = fil.filtrar(12, 0, 0, 0);
                    ic.setImage(imagen);
                    
                    plImg.revalidate();
                    plImg.repaint();
                    //jf.setVisible(true);
                }

            }
        });
        JMenuItem brillo = new JMenuItem(new AbstractAction("Brillo"){
            @Override public void actionPerformed(ActionEvent e){
                if(imagen!=null){
                    String fecha = JOptionPane.showInputDialog(null, "Ingrese el valor de brillo.", 
                    "Brillo", JOptionPane.QUESTION_MESSAGE);
                    int bll = 0;
                    try{
                        bll = Integer.parseInt(fecha);
                    }catch (Exception ex) {
                        System.out.println("TT");
                        bll = 0;
                    }
                    imagen = fil.filtrar(13, bll, 0, 0);
                    ic.setImage(imagen);
                    
                    plImg.revalidate();
                    plImg.repaint();
                    //jf.setVisible(true);
                }

            }
        });
        JMenuItem mosaico = new JMenuItem(new AbstractAction("Mosaico"){
            @Override public void actionPerformed(ActionEvent e){
                if(imagen!=null){
                    String fecha = JOptionPane.showInputDialog(null, 
                    "Ingrese los valores de los mosaicos separados por un espacio.", 
                    "Mosaico", JOptionPane.QUESTION_MESSAGE);
                    int n,m;
                    try{
                        String[] aux = fecha.split(" ");
                        n = Integer.parseInt(aux[0]);
                        m = Integer.parseInt(aux[1]);
                    }catch (Exception ex) {
                        n = 9;
                        m = 9;
                    }
                    imagen = fil.filtrar(14, 0, n, m);
                    ic.setImage(imagen);
                    
                    plImg.revalidate();
                    plImg.repaint();
                    //jf.setVisible(true);
                }

            }
        });
        JMenuItem inverso = new JMenuItem(new AbstractAction("Inverso"){
        	@Override public void actionPerformed(ActionEvent e){
        		if(imagen != null){
        			imagen = fil.filtrar(16,0,0,0);
        			ic.setImage(imagen);
        			plImg.revalidate();
        			plImg.repaint();
        		}
        	}
        });
        ///////////////////////////////////////////////////////////////////////////////////////
        JMenuItem blur = new JMenuItem(new AbstractAction("Blur"){
        	@Override public void actionPerformed(ActionEvent e){
        		if(imagen != null){
        			imagen = fil.filtrar(17,0,0,0);
        			ic.setImage(imagen);
        			plImg.revalidate();
        			plImg.repaint();
        		}
        	}
        });
        JMenuItem blurInt = new JMenuItem(new AbstractAction("Blur intenso"){
        	@Override public void actionPerformed(ActionEvent e){
        		if(imagen != null){
        			imagen = fil.filtrar(18,0,0,0);
        			ic.setImage(imagen);
        			plImg.revalidate();
        			plImg.repaint();
        		}
        	}
        });
        JMenuItem mblur = new JMenuItem(new AbstractAction("Motion Blur"){
        	@Override public void actionPerformed(ActionEvent e){
        		if(imagen != null){
        			imagen = fil.filtrar(19,0,0,0);
        			ic.setImage(imagen);
        			plImg.revalidate();
        			plImg.repaint();
        		}
        	}
        });
        JMenuItem bordesHrz = new JMenuItem(new AbstractAction("Encuentra bordes (Horizontal)"){
        	@Override public void actionPerformed(ActionEvent e){
        		if(imagen != null){
        			imagen = fil.filtrar(20,0,0,0);
        			ic.setImage(imagen);
        			plImg.revalidate();
        			plImg.repaint();
        		}
        	}
        });
        JMenuItem bordesVrt = new JMenuItem(new AbstractAction("Encuentra bordes (Vertical)"){
        	@Override public void actionPerformed(ActionEvent e){
        		if(imagen != null){
        			imagen = fil.filtrar(21,0,0,0);
        			ic.setImage(imagen);
        			plImg.revalidate();
        			plImg.repaint();
        		}
        	}
        });
        JMenuItem bordesDgn = new JMenuItem(new AbstractAction("Encuentra bordes (Diagonal)"){
        	@Override public void actionPerformed(ActionEvent e){
        		if(imagen != null){
        			imagen = fil.filtrar(22,0,0,0);
        			ic.setImage(imagen);
        			plImg.revalidate();
        			plImg.repaint();
        		}
        	}
        });
        JMenuItem bordesTds = new JMenuItem(new AbstractAction("Encuentra bordes"){
        	@Override public void actionPerformed(ActionEvent e){
        		if(imagen != null){
        			imagen = fil.filtrar(23,0,0,0);
        			ic.setImage(imagen);
        			plImg.revalidate();
        			plImg.repaint();
        		}
        	}
        });
        
        JMenuItem sharpen = new JMenuItem(new AbstractAction("Sharpen"){
        	@Override public void actionPerformed(ActionEvent e){
        		if(imagen != null){
        			imagen = fil.filtrar(24,0,0,0);
        			ic.setImage(imagen);
        			plImg.revalidate();
        			plImg.repaint();
        		}
        	}
        });
        JMenuItem sharpensbtl = new JMenuItem(new AbstractAction("Sharpen (Sutil)"){
        	@Override public void actionPerformed(ActionEvent e){
        		if(imagen != null){
        			imagen = fil.filtrar(25,0,0,0);
        			ic.setImage(imagen);
        			plImg.revalidate();
        			plImg.repaint();
        		}
        	}
        });
        JMenuItem sharpenexc = new JMenuItem(new AbstractAction("Sharpen (Excesivo)"){
        	@Override public void actionPerformed(ActionEvent e){
        		if(imagen != null){
        			imagen = fil.filtrar(26,0,0,0);
        			ic.setImage(imagen);
        			plImg.revalidate();
        			plImg.repaint();
        		}
        	}
        });
        JMenuItem emboss = new JMenuItem(new AbstractAction("Emboss"){
        	@Override public void actionPerformed(ActionEvent e){
        		if(imagen != null){
        			imagen = fil.filtrar(27,0,0,0);
        			ic.setImage(imagen);
        			plImg.revalidate();
        			plImg.repaint();
        		}
        	}
        });
        JMenuItem embossexa = new JMenuItem(new AbstractAction("Emboss (Exagerado)"){
        	@Override public void actionPerformed(ActionEvent e){
        		if(imagen != null){
        			imagen = fil.filtrar(28,0,0,0);
        			ic.setImage(imagen);
        			plImg.revalidate();
        			plImg.repaint();
        		}
        	}
        });
        JMenuItem media = new JMenuItem(new AbstractAction("Media"){
        	@Override public void actionPerformed(ActionEvent e){
        		if(imagen != null){
        			imagen = fil.filtrar(29,0,0,0);
        			ic.setImage(imagen);
        			plImg.revalidate();
        			plImg.repaint();
        		}
        	}
        });
        JMenuItem mediana = new JMenuItem(new AbstractAction("Mediana"){
        	@Override public void actionPerformed(ActionEvent e){
        		if(imagen != null){
        			imagen = fil.filtrar(30,0,0,0);
        			ic.setImage(imagen);
        			plImg.revalidate();
        			plImg.repaint();
        		}
        	}
        });
        JMenuItem psico = new JMenuItem(new AbstractAction("Psicodelico"){
        	@Override public void actionPerformed(ActionEvent e){
        		if(imagen != null){
        			imagen = fil.filtrar(31,0,0,0);
        			ic.setImage(imagen);
        			plImg.revalidate();
        			plImg.repaint();
        		}
        	}
        });
        JMenuItem sepia = new JMenuItem(new AbstractAction("Sepia"){
        	@Override public void actionPerformed(ActionEvent e){
        		if(imagen != null){
        			imagen = fil.filtrar(32,0,0,0);
        			ic.setImage(imagen);
        			plImg.revalidate();
        			plImg.repaint();
        		}
        	}
        });
        ///////////////////////////////////////////////////////////////////////////////////////////
        JMenuItem arrobagris = new JMenuItem(new AbstractAction("@ - Escala de grises"){
            @Override public void actionPerformed(ActionEvent e){
                if(imagen != null){
                    String fecha = JOptionPane.showInputDialog(null, 
                    "Ingrese los valores de los mosaicos separados por un espacio.", 
                    "Mosaico", JOptionPane.QUESTION_MESSAGE);
                    int n,m;
                    try{
                        String[] aux = fecha.split(" ");
                        n = Integer.parseInt(aux[0]);
                        m = Integer.parseInt(aux[1]);
                    }catch (Exception ex) {
                        n = 9;
                        m = 9;
                    }
                    imagen = fil.filtrar(10,0,0,0);
                    escritor.setImage(imagen);
                    imagen = escritor.procesa(0, "@", n, m);
                    if(imagen == null)
                        return;
                    ic.setImage(imagen);
                    plImg.revalidate();
                    plImg.repaint();
                    //imagen = fil.getOriginal();
                }
            }
        });
        JMenuItem arrobacolor = new JMenuItem(new AbstractAction("@ - Color"){
            @Override public void actionPerformed(ActionEvent e){
                if(imagen != null){
                    String fecha = JOptionPane.showInputDialog(null, 
                    "Ingrese los valores de los mosaicos separados por un espacio.", 
                    "Mosaico", JOptionPane.QUESTION_MESSAGE);
                    int n,m;
                    try{
                        String[] aux = fecha.split(" ");
                        n = Integer.parseInt(aux[0]);
                        m = Integer.parseInt(aux[1]);
                    }catch (Exception ex) {
                        n = 9;
                        m = 9;
                    }
                    escritor.setImage(imagen);
                    imagen = escritor.procesa(0, "@", n, m);
                    if(imagen == null)
                        return;
                    ic.setImage(imagen);
                    plImg.revalidate();
                    plImg.repaint();
                    //imagen = fil.getOriginal();
                }
            }
        });
        JMenuItem emegris = new JMenuItem(new AbstractAction("M - Escala de grises"){
            @Override public void actionPerformed(ActionEvent e){
                if(imagen != null){
                    String fecha = JOptionPane.showInputDialog(null, 
                    "Ingrese los valores de los mosaicos separados por un espacio.", 
                    "Mosaico", JOptionPane.QUESTION_MESSAGE);
                    int n,m;
                    try{
                        String[] aux = fecha.split(" ");
                        n = Integer.parseInt(aux[0]);
                        m = Integer.parseInt(aux[1]);
                    }catch (Exception ex) {
                        n = 9;
                        m = 9;
                    }
                    imagen = fil.filtrar(10,0,0,0);
                    escritor.setImage(imagen);
                    imagen = escritor.procesa(0, "M", n, m);
                    if(imagen == null)
                        return;
                    ic.setImage(imagen);
                    plImg.revalidate();
                    plImg.repaint();
                    //imagen = fil.getOriginal();
                }
            }
        });
        JMenuItem emecolor = new JMenuItem(new AbstractAction("M - Color"){
            @Override public void actionPerformed(ActionEvent e){
                if(imagen != null){
                    String fecha = JOptionPane.showInputDialog(null, 
                    "Ingrese los valores de los mosaicos separados por un espacio.", 
                    "Mosaico", JOptionPane.QUESTION_MESSAGE);
                    int n,m;
                    try{
                        String[] aux = fecha.split(" ");
                        n = Integer.parseInt(aux[0]);
                        m = Integer.parseInt(aux[1]);
                    }catch (Exception ex) {
                        n = 9;
                        m = 9;
                    }
                    escritor.setImage(imagen);
                    imagen = escritor.procesa(0, "M", n, m);
                    if(imagen == null)
                        return;
                    ic.setImage(imagen);
                    plImg.revalidate();
                    plImg.repaint();
                    //imagen = fil.getOriginal();
                }
            }
        });
        JMenuItem textocolor = new JMenuItem(new AbstractAction("Texto a Color"){
            @Override public void actionPerformed(ActionEvent e){
                if(imagen != null){
                    String fecha = JOptionPane.showInputDialog(null, 
                    "Ingrese los valores de los mosaicos separados por un espacio.", 
                    "Mosaico", JOptionPane.QUESTION_MESSAGE);
                    int n,m;
                    try{
                        String[] aux = fecha.split(" ");
                        n = Integer.parseInt(aux[0]);
                        m = Integer.parseInt(aux[1]);
                    }catch (Exception ex) {
                        n = 9;
                        m = 9;
                    }
                    String txt = JOptionPane.showInputDialog(null, 
                    "Ingrese el texto a procesar", 
                    "Texto", JOptionPane.QUESTION_MESSAGE);
                    escritor.setImage(imagen);
                    imagen = escritor.procesa(0, txt, n, m);
                    if(imagen == null)
                        return;
                    ic.setImage(imagen);
                    plImg.revalidate();
                    plImg.repaint();
                    //imagen = fil.getOriginal();
                }
            }
        });

        JMenuItem escalaBN = new JMenuItem(new AbstractAction("Escala de caracteres (B/N)"){
            @Override public void actionPerformed(ActionEvent e){
                if(imagen != null){
                    String fecha = JOptionPane.showInputDialog(null, 
                    "Ingrese los valores de los mosaicos separados por un espacio.", 
                    "Mosaico", JOptionPane.QUESTION_MESSAGE);
                    int n,m;
                    try{
                        String[] aux = fecha.split(" ");
                        n = Integer.parseInt(aux[0]);
                        m = Integer.parseInt(aux[1]);
                    }catch (Exception ex) {
                        n = 9;
                        m = 9;
                    }
                    
                    escritor.setImage(imagen);
                    imagen = escritor.procesa(1, null, n, m);
                    if(imagen == null)
                        return;
                    ic.setImage(imagen);
                    plImg.revalidate();
                    plImg.repaint();
                    //imagen = fil.getOriginal();
                }
            }
        });

        JMenuItem escalaGris = new JMenuItem(new AbstractAction("Escala de caracteres (Grises)"){
            @Override public void actionPerformed(ActionEvent e){
                if(imagen != null){
                    String fecha = JOptionPane.showInputDialog(null, 
                    "Ingrese los valores de los mosaicos separados por un espacio.", 
                    "Mosaico", JOptionPane.QUESTION_MESSAGE);
                    int n,m;
                    try{
                        String[] aux = fecha.split(" ");
                        n = Integer.parseInt(aux[0]);
                        m = Integer.parseInt(aux[1]);
                    }catch (Exception ex) {
                        n = 9;
                        m = 9;
                    }
                    imagen = fil.filtrar(10,0,0,0);
                    escritor.setImage(imagen);
                    imagen = escritor.procesa(2, null, n, m);
                    if(imagen == null)
                        return;
                    ic.setImage(imagen);
                    plImg.revalidate();
                    plImg.repaint();
                    //imagen = fil.getOriginal();
                }
            }
        });

        JMenuItem escalaColor = new JMenuItem(new AbstractAction("Escala de caracteres (Color)"){
            @Override public void actionPerformed(ActionEvent e){
                if(imagen != null){
                    String fecha = JOptionPane.showInputDialog(null, 
                    "Ingrese los valores de los mosaicos separados por un espacio.", 
                    "Mosaico", JOptionPane.QUESTION_MESSAGE);
                    int n,m;
                    try{
                        String[] aux = fecha.split(" ");
                        n = Integer.parseInt(aux[0]);
                        m = Integer.parseInt(aux[1]);
                    }catch (Exception ex) {
                        n = 9;
                        m = 9;
                    }
                    escritor.setImage(imagen);
                    imagen = escritor.procesa(2, null, n, m);
                    if(imagen == null)
                        return;
                    ic.setImage(imagen);
                    plImg.revalidate();
                    plImg.repaint();
                    //imagen = fil.getOriginal();
                }
            }
        });

        JMenuItem naipes = new JMenuItem(new AbstractAction("Naipes"){
            @Override public void actionPerformed(ActionEvent e){
                if(imagen != null){
                    String fecha = JOptionPane.showInputDialog(null, 
                    "Ingrese los valores de los mosaicos separados por un espacio.", 
                    "Mosaico", JOptionPane.QUESTION_MESSAGE);
                    int n,m;
                    try{
                        String[] aux = fecha.split(" ");
                        n = Integer.parseInt(aux[0]);
                        m = Integer.parseInt(aux[1]);
                    }catch (Exception ex) {
                        n = 9;
                        m = 9;
                    }
                    escritor.setImage(imagen);
                    imagen = escritor.procesa(5, null, n, m);
                    if(imagen == null)
                        return;
                    ic.setImage(imagen);
                    plImg.revalidate();
                    plImg.repaint();
                    //imagen = fil.getOriginal();
                }
            }
        });
        JMenuItem dominoN = new JMenuItem(new AbstractAction("Domino Negro"){
            @Override public void actionPerformed(ActionEvent e){
                if(imagen != null){
                    String fecha = JOptionPane.showInputDialog(null, 
                    "Ingrese los valores de los mosaicos separados por un espacio.", 
                    "Mosaico", JOptionPane.QUESTION_MESSAGE);
                    int n,m;
                    try{
                        String[] aux = fecha.split(" ");
                        n = Integer.parseInt(aux[0]);
                        m = Integer.parseInt(aux[1]);
                    }catch (Exception ex) {
                        n = 9;
                        m = 9;
                    }
                    escritor.setImage(imagen);
                    imagen = escritor.procesa(6, null, n, m);
                    if(imagen == null)
                        return;
                    ic.setImage(imagen);
                    plImg.revalidate();
                    plImg.repaint();
                    //imagen = fil.getOriginal();
                }
            }
        });
        JMenuItem dominoB = new JMenuItem(new AbstractAction("Domino Blanco"){
            @Override public void actionPerformed(ActionEvent e){
                if(imagen != null){
                    String fecha = JOptionPane.showInputDialog(null, 
                    "Ingrese los valores de los mosaicos separados por un espacio.", 
                    "Mosaico", JOptionPane.QUESTION_MESSAGE);
                    int n,m;
                    try{
                        String[] aux = fecha.split(" ");
                        n = Integer.parseInt(aux[0]);
                        m = Integer.parseInt(aux[1]);
                    }catch (Exception ex) {
                        n = 9;
                        m = 9;
                    }
                    escritor.setImage(imagen);
                    imagen = escritor.procesa(4, null, n, m);
                    if(imagen == null)
                        return;
                    ic.setImage(imagen);
                    plImg.revalidate();
                    plImg.repaint();
                    //imagen = fil.getOriginal();
                }
            }
        });
        //////////////////////////////////////////////////////////////////////////////////////
        JMenuItem marcaRoja = new JMenuItem(new AbstractAction("Marca Roja"){
            @Override public void actionPerformed(ActionEvent e){
                if(imagen == null){
                    return;
                }
                imagen = fil.filtrar(33,0,0,0);
                ic.setImage(imagen);
                plImg.revalidate();
                plImg.repaint();

            }
        });
        JMenuItem recursivaColor = new JMenuItem(new AbstractAction("Imagen recursiva (Color)"){
            @Override public void actionPerformed(ActionEvent e){
                if(imagen == null){
                    return;
                }
                String fecha = JOptionPane.showInputDialog(null, 
                    "Ingrese los valores de los mosaicos separados por un espacio.", 
                    "Mosaico", JOptionPane.QUESTION_MESSAGE);
                    int n,m;
                    try{
                        String[] aux = fecha.split(" ");
                        n = Integer.parseInt(aux[0]);
                        m = Integer.parseInt(aux[1]);
                    }catch (Exception ex) {
                        n = 9;
                        m = 9;
                    }

                imagen = fil.filtrar(35,0,n,m);
                ic.setImage(imagen);
                plImg.revalidate();
                plImg.repaint();

            }
        });
        JMenuItem recursivaGrises = new JMenuItem(new AbstractAction("Imagen recursiva (Grises)"){
            @Override public void actionPerformed(ActionEvent e){
                if(imagen == null){
                    return;
                }
                String fecha = JOptionPane.showInputDialog(null, 
                    "Ingrese los valores de los mosaicos separados por un espacio.", 
                    "Mosaico", JOptionPane.QUESTION_MESSAGE);
                    int n,m;
                    try{
                        String[] aux = fecha.split(" ");
                        n = Integer.parseInt(aux[0]);
                        m = Integer.parseInt(aux[1]);
                    }catch (Exception ex) {
                        n = 9;
                        m = 9;
                    }

                imagen = fil.filtrar(36,0,n,m);
                ic.setImage(imagen);
                plImg.revalidate();
                plImg.repaint();

            }
        });
        JMenuItem fusion = new JMenuItem(new AbstractAction("Fusion"){
            @Override public void actionPerformed(ActionEvent e){
                if(imagen == null){
                    return;
                }
                JFileChooser fc = new JFileChooser();
                int rv = fc.showOpenDialog(null);
                if(rv == JFileChooser.APPROVE_OPTION){
                    //System.out.print("YES!");

                    File file = fc.getSelectedFile();
                    
                    //abrirImagen(file, imagen);
                    try{
                        BufferedImage imgtmp = ImageIO.read(file);
                        String fecha = JOptionPane.showInputDialog(null, 
                    "Ingrese el porcentaje de la nueva imagen en la fusion.", 
                    "Fusion", JOptionPane.QUESTION_MESSAGE);
                        int pc;
                        try{
                        	pc = Integer.parseInt(fecha);
                        }catch(Exception exc){
                        	pc = 50;
                        }
                        imagen = fil.fusion(imgtmp, pc);
                        ic.setImage(imagen);
	    	            plImg.revalidate();
    	    	        plImg.repaint();

                    }catch(Exception ex){

                    }
                }

            }
        });

        ////////////////////////////////////////////////////////////////////////////////////////////////////

        JMenu tarea5 = new JMenu("Tarea 5");

        JMenuItem oleo = new JMenuItem(new AbstractAction("Oleo (Color)"){
            @Override public void actionPerformed(ActionEvent e){
                if(imagen == null){
                    return;
                }
                imagen = fil.filtrar(37,0,0,0);
                ic.setImage(imagen);
                plImg.revalidate();
                plImg.repaint();

            }
        });

        JMenuItem oleoGris = new JMenuItem(new AbstractAction("Oleo (Grises)"){
            @Override public void actionPerformed(ActionEvent e){
                if(imagen == null){
                    return;
                }
                imagen = fil.filtrar(38,0,0,0);
                ic.setImage(imagen);
                plImg.revalidate();
                plImg.repaint();

            }
        });

        JMenuItem maximo = new JMenuItem(new AbstractAction("Maximo (Color)"){
            @Override public void actionPerformed(ActionEvent e){
                if(imagen == null){
                    return;
                }
                imagen = fil.filtrar(39,0,0,0);
                ic.setImage(imagen);
                plImg.revalidate();
                plImg.repaint();

            }
        });

        JMenuItem maximoGris = new JMenuItem(new AbstractAction("Maximo (Grises)"){
            @Override public void actionPerformed(ActionEvent e){
                if(imagen == null){
                    return;
                }
                imagen = fil.filtrar(40,0,0,0);
                ic.setImage(imagen);
                plImg.revalidate();
                plImg.repaint();

            }
        });

        JMenuItem minimo = new JMenuItem(new AbstractAction("Minimo (Color)"){
            @Override public void actionPerformed(ActionEvent e){
                if(imagen == null){
                    return;
                }
                imagen = fil.filtrar(41,0,0,0);
                ic.setImage(imagen);
                plImg.revalidate();
                plImg.repaint();

            }
        });

        JMenuItem minimoGris = new JMenuItem(new AbstractAction("Minimo (Grises)"){
            @Override public void actionPerformed(ActionEvent e){
                if(imagen == null){
                    return;
                }
                imagen = fil.filtrar(42,0,0,0);
                ic.setImage(imagen);
                plImg.revalidate();
                plImg.repaint();

            }
        });


        JMenuItem att = new JMenuItem(new AbstractAction("ATT"){
            @Override public void actionPerformed(ActionEvent e){
                if(imagen == null){
                    return;
                }
                String fecha = JOptionPane.showInputDialog(null, 
                    "Igrese el tamaño de las franjas.", 
                    "ATT", JOptionPane.QUESTION_MESSAGE);
                int tam;
                try{
                    tam = Integer.parseInt(fecha);
                }catch(Exception ex){
                    tam = 9;
                }
                imagen = fil.filtrar(43,tam,0,0);
                ic.setImage(imagen);
                plImg.revalidate();
                plImg.repaint();

            }
        });

        JMenuItem semitonos = new JMenuItem(new AbstractAction("Semitonos"){
            @Override public void actionPerformed(ActionEvent e){
                if(imagen == null){
                    return;
                }
                imagen = fil.filtrar(44,0,0,0);
                ic.setImage(imagen);
                plImg.revalidate();
                plImg.repaint();

            }
        });

        JMenuItem favicon = new JMenuItem(new AbstractAction("favicon"){
            @Override public void actionPerformed(ActionEvent e){
                 if(imagen == null){
                    return;
                }
                JFileChooser fc = new JFileChooser();
                int rv = fc.showOpenDialog(null);
                if(rv == JFileChooser.APPROVE_OPTION){
                    //System.out.print("YES!");

                    File file = fc.getSelectedFile();
                    
                    //abrirImagen(file, imagen);
                    try{
                        BufferedImage imgtmp = ImageIO.read(file);
                        String fecha = JOptionPane.showInputDialog(null, 
                    "Ingrese la posición del favicon:\n0.-esquina superior izquierda"+
                    "1.-esquina superior derecha\n2.-esquina inferior izquierda\n3.-esquina inferiro derecha", 
                    "Favicon", JOptionPane.QUESTION_MESSAGE);
                        String fechasss = JOptionPane.showInputDialog(null, 
                    "Igrese el porcentaje de intensidad del favicon [0,100]", 
                    "Favicon", JOptionPane.QUESTION_MESSAGE);
                        int pc;
                        int transparencia;
                        try{
                            pc = Integer.parseInt(fecha);
                            transparencia = Integer.parseInt(fechasss);
                        }catch(Exception exc){
                            pc = 0;
                            transparencia = 0;
                        }
                        if(pc < 0)
                            pc = 0;
                        if(pc > 3)
                            pc = 3;
                        if(transparencia < 0)
                            transparencia = 0;
                        if(transparencia > 100)
                            transparencia = 100;
                        imagen = fil.favicon(imgtmp, pc, transparencia);
                        ic.setImage(imagen);
                        plImg.revalidate();
                        plImg.repaint();

                    }catch(Exception ex){

                    }
                }   

            }
        });/////////////////////////////////////////////////////////////////////////////////////////////////
        ///////////////////////////////////////////////////////////////////////////////////////////////////
        JMenuItem ditheringSimle = new JMenuItem(new AbstractAction("Simple"){
            @Override public void actionPerformed(ActionEvent e){
                if(imagen == null){
                    return;
                }
                imagen = fil.filtrar(45,0,0,0);
                ic.setImage(imagen);
                plImg.revalidate();
                plImg.repaint();

            }
        });

        JMenuItem ditheringFS = new JMenuItem(new AbstractAction("Floyd-Steinberg"){
            @Override public void actionPerformed(ActionEvent e){
                if(imagen == null){
                    return;
                }
                imagen = fil.filtrar(46,0,0,0);
                ic.setImage(imagen);
                plImg.revalidate();
                plImg.repaint();

            }
        });

        JMenuItem ditheringFSF = new JMenuItem(new AbstractAction("Floyd-Steinberg(Falso)"){
            @Override public void actionPerformed(ActionEvent e){
                if(imagen == null){
                    return;
                }
                imagen = fil.filtrar(47,0,0,0);
                ic.setImage(imagen);
                plImg.revalidate();
                plImg.repaint();

            }
        });

        JMenuItem ditheringJJN = new JMenuItem(new AbstractAction("Jarvis-Judice-Ninke"){
            @Override public void actionPerformed(ActionEvent e){
                if(imagen == null){
                    return;
                }
                imagen = fil.filtrar(48,0,0,0);
                ic.setImage(imagen);
                plImg.revalidate();
                plImg.repaint();

            }
        });

        JMenuItem ditheringA = new JMenuItem(new AbstractAction("Atkinson"){
            @Override public void actionPerformed(ActionEvent e){
                if(imagen == null){
                    return;
                }
                imagen = fil.filtrar(49,0,0,0);
                ic.setImage(imagen);
                plImg.revalidate();
                plImg.repaint();

            }
        });


        filtros.add(mica);
        filtros.add(aleatorio);
        filtros.add(rojo);
        filtros.add(verde);
        filtros.add(azul);
        filtros.add(verde_azul);
        filtros.add(rojo_azul);
        filtros.add(rojo_verde);
        filtros.add(escala_gris_media);
        filtros.add(escala_gris_rojo);
        filtros.add(escala_gris_verde);
        filtros.add(escala_gris_azul);
        filtros.add(escala_gris_fix);
        filtros.add(contraste);
        filtros.add(contraste_inv);
        filtros.add(brillo);
        filtros.add(mosaico);
        filtros.add(inverso);
        filtros.add(sepia);


        filtros2.add(blur);
        filtros2.add(blurInt);
        filtros2.add(mblur);
        filtros2.add(bordesHrz);
        filtros2.add(bordesVrt);
        filtros2.add(bordesDgn);
        filtros2.add(bordesTds);
        filtros2.add(sharpen);
        filtros2.add(sharpensbtl);
        filtros2.add(sharpenexc);
        filtros2.add(emboss);
        filtros2.add(embossexa);
        filtros2.add(media);
        filtros2.add(mediana);
        filtros2.add(psico);

        procesos.add(arrobagris);
        procesos.add(arrobacolor);
        procesos.add(emegris);
        procesos.add(emecolor);
        procesos.add(textocolor);
        procesos.add(escalaBN);
        procesos.add(escalaGris);
        procesos.add(escalaColor);
        procesos.add(naipes);
        procesos.add(dominoN);
        procesos.add(dominoB);

        marca.add(marcaRoja);

        recursivas.add(recursivaColor);
        recursivas.add(recursivaGrises);

        ffusion.add(fusion);

        tarea5.add(oleo);
        tarea5.add(oleoGris);
        tarea5.add(maximo);
        tarea5.add(maximoGris);
        tarea5.add(minimo);
        tarea5.add(minimoGris);
        tarea5.add(att);
        tarea5.add(semitonos);
        tarea5.add(favicon);

        dithering.add(ditheringSimle);
        dithering.add(ditheringFS);
        dithering.add(ditheringFSF);
        dithering.add(ditheringJJN);
        dithering.add(ditheringA);

        menu.add(filtros);
        menu.add(filtros2);
        menu.add(procesos);
        menu.add(marca);
        menu.add(recursivas);
        menu.add(ffusion);
        menu.add(tarea5);
        menu.add(dithering);
        //emptyLabel.setPreferredSize(new Dimension(800, 500));
        //jf.getContentPane().add(emptyLabel, BorderLayout.CENTER);
        */
        jf.setJMenuBar(menu);

        jf.pack();
        jf.setSize(800,500);
        jf.setVisible(true);
    }

    private static void abrirImagen(File file, BufferedImage image){
        try{
            image = ImageIO.read(file);
            //System.out.println(file.getPath());
            //System.out.println(image+"\n");
        }catch(Exception e){    
        }
        
    }

    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable(){
            public void run(){
                createGUI();    
            }
        });
    }
}