/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment.pkg1;

/**
 *
 * @author Talat Zubair
 */
public class Assignment1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
/*        Picture p = new Picture("C:\\Users\\Talat Zubair\\Documents\\NetBeansProjects\\Assignment 1\\HJoceanSmall.png");
        p.show();
        SeamCarver s_hor = new SeamCarver(p);
        s_hor.removeHorizontalSeam(s_hor.findHorizontalSeam());
        SeamCarver s_ver = new SeamCarver(s_hor.picture);
        s_ver.removeVerticalSeam(s_ver.findVerticalSeam());
        s_ver.picture.show();*/
  
 
                SeamCarver tmp = new SeamCarver(new Picture("HJoceanSmall.png"));
                System.out.println(tmp.energy(0, 0) + " " + tmp.energy(12,12)); //Should output 183.. and 7.7
 
                for (int i=0; i<100; i++)
                    tmp.removeVerticalSeam(tmp.findVerticalSeam());
                for (int i=0; i<75; i++)
                    tmp.removeHorizontalSeam(tmp.findHorizontalSeam());
                tmp.picture.show(); //Should display correct resized image

    }
    
}
