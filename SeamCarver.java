/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment.pkg1;
 
import java.lang.*;
import java.util.*;
import java.awt.Color;


/**
 *
 * @author Talat Zubair
 */
public class SeamCarver 
{
    private int width;
    private int height;
    private int[][] intensity;
    //private double[][] energy;
    public Picture picture;
    private int[] HorizontalSeam;
    private int[] VerticalSeam;
  
    
    public SeamCarver(Picture picture)
    {
        if (picture == null)
        {
            throw new java.lang.NullPointerException();
        }
        
        // Initializing the width and height of the picture
        width = picture.width();
        height = picture.height();
        
        //Initializing the intensity and energy matrices
        intensity = new int[height][width];
        //energy = new double[height][width];
        
        //Populating the intensity matrix with intensity values
        for (int i = 0; i < height; i++) 
        {
            for (int j = 0; j < width; j++) 
            {
                intensity[i][j] = picture.get(j, i).getRGB();
            }
        }
        
    }

    public void SetPicture(Picture picture)
    {
        this.picture = picture;
    }
    
    public Picture picture() 
    {
        picture = new Picture(width(), height());
        for (int i = 0; i < height(); i++) 
        {
            for (int j = 0; j < width(); j++) 
            {
                picture.set(j, i, new Color(intensity[i][j]));
            }
        }        
        return picture;
    }

    public int width() 
    {
        return width;
    }   

    public int height() 
    {
        return height;
    }

    
    public double energy(int c, int r) 
    {
        int Rx = 0, Gx  = 0, Bx = 0, Ry = 0, Gy = 0, By = 0;
        if (c >= width() || r >= height() || c < 0 || r < 0)
        {
            //System.out.println("c: " + c  + "  r: " + r);
            throw new java.lang.IndexOutOfBoundsException();
        }
 
        //System.out.println("c: " + c + " r: " + r);
        
        //Creating Color instances of neighbouring intensity values
        if (r == 0)
        {
            if (c == 0)
            {
                Color right = new Color(intensity[r][c+1]);
                Color down = new Color(intensity[r+1][c]);
                //Finding the difference b/w horizontal neighbours
                Rx = right.getRed();
                Gx = right.getGreen();
                Bx = right.getBlue();

                //Finding the difference b/w vertical neighbours
                Ry = down.getRed();
                Gy = down.getGreen();
                By = down.getBlue();
            }
            else if (c == width() - 1)
            {
                Color left = new Color(intensity[r][c-1]);
                Color down = new Color(intensity[r+1][c]);
            
                //Finding the difference b/w horizontal neighbours
                Rx = left.getRed();
                Gx = left.getGreen();
                Bx = left.getBlue();

                //Finding the difference b/w vertical neighbours
                Ry = down.getRed();
                Gy = down.getGreen();
                By = down.getBlue();
            }
            else
            {
                Color left = new Color(intensity[r][c-1]);
                Color right = new Color(intensity[r][c+1]);
                Color down = new Color(intensity[r+1][c]);
            
                //Finding the difference b/w horizontal neighbours
                Rx = left.getRed() - right.getRed();
                Gx = left.getGreen() - right.getGreen();
                Bx = left.getBlue() - right.getBlue();

                //Finding the difference b/w vertical neighbours
                Ry = down.getRed();
                Gy = down.getGreen();
                By = down.getBlue();
            }
        }
        
        else if (c == 0)
        {
            if (r == 0)
            {
                Color right = new Color(intensity[r][c+1]);
                Color down = new Color(intensity[r+1][c]);
                //Finding the difference b/w horizontal neighbours
                Rx = right.getRed();
                Gx = right.getGreen();
                Bx = right.getBlue();

                //Finding the difference b/w vertical neighbours
                Ry = down.getRed();
                Gy = down.getGreen();
                By = down.getBlue();
            }
            else if (r == height() - 1)
            {
                Color right = new Color(intensity[r][c+1]);
                Color up = new Color(intensity[r-1][c]);  
            
                //Finding the difference b/w horizontal neighbours
                Rx = right.getRed();
                Gx = right.getGreen();
                Bx = right.getBlue();

                //Finding the difference b/w vertical neighbours
                Ry = up.getRed();
                Gy = up.getGreen();
                By = up.getBlue();
            }
            else
            {
                Color right = new Color(intensity[r][c+1]);
                Color up = new Color(intensity[r-1][c]);
                Color down = new Color(intensity[r+1][c]);   
            
                //Finding the difference b/w horizontal neighbours
                Rx = right.getRed();
                Gx = right.getGreen();
                Bx = right.getBlue();

                //Finding the difference b/w vertical neighbours
                Ry = up.getRed() - down.getRed();
                Gy = up.getGreen() - down.getGreen();
                By = up.getBlue() - down.getBlue();
            }
        }
        
        else if (r == height() - 1)
        {
            if (c == width() - 1)
            {
                Color left = new Color(intensity[r][c-1]);
                Color up = new Color(intensity[r-1][c]);
            
                //Finding the difference b/w horizontal neighbours
                Rx = left.getRed();
                Gx = left.getGreen();
                Bx = left.getBlue();

                //Finding the difference b/w vertical neighbours
                Ry = up.getRed();
                Gy = up.getGreen();
                By = up.getBlue();
            }
            else if (c == 0)
            {
                Color right = new Color(intensity[r][c+1]);    
                Color up = new Color(intensity[r-1][c]);
                
                //Finding the difference b/w horizontal neighbours
                Rx = right.getRed();
                Gx = right.getGreen();
                Bx = right.getBlue();

                //Finding the difference b/w vertical neighbours
                Ry = up.getRed();
                Gy = up.getGreen();
                By = up.getBlue();
            }
            else
            {
                Color left = new Color(intensity[r][c-1]);
                Color right = new Color(intensity[r][c+1]);    
                Color up = new Color(intensity[r-1][c]);
                
                //Finding the difference b/w horizontal neighbours
                Rx = left.getRed() - right.getRed();
                Gx = left.getGreen() - right.getGreen();
                Bx = left.getBlue() - right.getBlue();

                //Finding the difference b/w vertical neighbours
                Ry = up.getRed();
                Gy = up.getGreen();
                By = up.getBlue();
            }
        }
        
        else if (c == width() - 1)
        {
            if (r == height() - 1)
            {
                Color left = new Color(intensity[r][c-1]);        
                Color up = new Color(intensity[r-1][c]);

                //Finding the difference b/w horizontal neighbours
                Rx = left.getRed();
                Gx = left.getGreen();
                Bx = left.getBlue();

                //Finding the difference b/w vertical neighbours
                Ry = up.getRed();
                Gy = up.getGreen();
                By = up.getBlue();
            }
            else if (r == 0)
            {
                Color left = new Color(intensity[r][c-1]);        
                Color down = new Color(intensity[r+1][c]);

                //Finding the difference b/w horizontal neighbours
                Rx = left.getRed();
                Gx = left.getGreen();
                Bx = left.getBlue();

                //Finding the difference b/w vertical neighbours
                Ry = down.getRed();
                Gy = down.getGreen();
                By = down.getBlue();                
            }
            else
            {
                Color left = new Color(intensity[r][c-1]);        
                Color up = new Color(intensity[r-1][c]);
                Color down = new Color(intensity[r+1][c]);

                //Finding the difference b/w horizontal neighbours
                Rx = left.getRed();
                Gx = left.getGreen();
                Bx = left.getBlue();

                //Finding the difference b/w vertical neighbours
                Ry = up.getRed() - down.getRed();
                Gy = up.getGreen() - down.getGreen();
                By = up.getBlue() - down.getBlue();
            }
        }
        
        else if (c != 0 && r != 0 && c != width() - 1 && r != height() - 1)
        {            
            Color left = new Color(intensity[r][c-1]);
            Color right = new Color(intensity[r][c+1]);        
            Color up = new Color(intensity[r-1][c]);
            Color down = new Color(intensity[r+1][c]);

            //Finding the difference b/w horizontal neighbours
            Rx = left.getRed() - right.getRed();
            Gx = left.getGreen() - right.getGreen();
            Bx = left.getBlue() - right.getBlue();


            //Finding the difference b/w vertical neighbours
            Ry = up.getRed() - down.getRed();
            Gy = up.getGreen() - down.getGreen();
            By = up.getBlue() - down.getBlue();
        }    
        
        //Gradient in horizontal direction
        double grad_x = Math.pow(Rx, 2) + Math.pow(Gx, 2) + Math.pow(Bx, 2);
        
        //Gradient in vertical direction
        double grad_y = Math.pow(Ry, 2) + Math.pow(Gy, 2) + Math.pow(By, 2);

        //Computing overall gradient of intensity value
        return Math.sqrt(grad_x + grad_y);        
    }

    
    public int[] findHorizontalSeam() 
    {
        HorizontalSeam = new int[width()-1];
        //System.out.println(HorizontalSeam.length);
        //System.out.println(width() - 1);
        int counter = 0;
        double smallest = energy(0,0);
        int row_index;
        double minimum;
        
        //For finding the lowest energy value in the first column
        for (int r = 0; r < height(); r++)
        {
            if (smallest > energy(0,r))
            {
                smallest = energy(0,r);
                HorizontalSeam[counter] = r;
            }
        }
        counter = counter + 1;
        
        
        //For every column, it picks the row index the lowest neighbor 
        //of the previous element in the array from the energy matrix
        for (int c = 1; c < width()-1; c++)
        {
            row_index = HorizontalSeam[counter-1];
            
            //System.out.println(row_index);
            
            if (row_index == 0)
            {
                minimum = Math.min(energy(c, row_index), energy(c, row_index+1));
                if (minimum == energy(c, row_index))
                {
                    HorizontalSeam[counter] = row_index;
                }
                else if (minimum == energy(c, row_index+1))
                {
                    HorizontalSeam[counter] = row_index+1;
                }
                counter = counter + 1;
            }
            else if (row_index == height() - 1)
            {
                 minimum = Math.min(energy(c, row_index), energy(c, row_index-1));
                if (minimum == energy(c, row_index))
                {
                    HorizontalSeam[counter] = row_index;
                }
                else if (minimum == energy(c, row_index-1))
                {
                    HorizontalSeam[counter] = row_index-1;
                }
                counter = counter + 1;
            }
            else
            {
                minimum = Math.min(Math.min(energy(c, row_index), energy(c, row_index-1)), energy(c, row_index+1));

                //System.out.println("c: " + c + " row: " + row_index + " counter: " + counter);
                
                if (minimum == energy(c, row_index))
                {
                    HorizontalSeam[counter] = row_index;
                }
                else if (minimum == energy(c, row_index-1))
                {
                    HorizontalSeam[counter] = row_index-1;
                }
                else if (minimum == energy(c, row_index+1))
                {
                    HorizontalSeam[counter] = row_index+1;
                }
                counter = counter + 1;
            }
        }
        return HorizontalSeam;
    }
    
    

    public int[] findVerticalSeam() 
    {
        VerticalSeam = new int[height()];
        int counter = 0;
        double smallest = energy(0,0);
        int col_index;
        double minimum;
        
        //For finding the lowest energy value in the first row
        for (int c = 0; c < width(); c++)
        {
            if (smallest > energy(c, 0))
            {
                smallest = energy(c, 0);
                VerticalSeam[counter] = c;
            }
        }
        counter = counter + 1;

        //For every row, it picks the column index the lowest neighbor 
        //of the previous element in the array from the energy matrix
        for (int r = 1; r < height(); r++)
        {
            col_index = VerticalSeam[counter-1];
            
            if (col_index == 0)
            {
                minimum = Math.min(energy(col_index, r), energy(col_index+1, r));
                if (minimum == energy(col_index, r))
                {
                    VerticalSeam[counter] = col_index;
                }
                else if (minimum == energy(col_index+1, r))
                {
                    VerticalSeam[counter] = col_index+1;
                }
                counter = counter + 1;                
            }
            else if (col_index == width()-1)
            {
                minimum = (Math.min(energy(col_index, r), energy(col_index-1,r)));
                if (minimum == energy(col_index, r))
                {
                    VerticalSeam[counter] = col_index;
                }
                else if (minimum == energy(col_index-1, r))
                {
                    VerticalSeam[counter] = col_index-1;
                }
                counter = counter + 1;                
            }
           else
            {
//                System.out.println("r: " + r + " col: " + col_index + " counter: " + counter);
                minimum = Math.min(Math.min(energy(col_index, r), energy(col_index+1, r)), energy(col_index-1,r));
                if (minimum == energy(col_index, r))
                {
                    VerticalSeam[counter] = col_index;
                }
                else if (minimum == energy(col_index-1, r))
                {
                    VerticalSeam[counter] = col_index-1;
                }
                else if (minimum == energy(col_index+1, r))
                {
                    VerticalSeam[counter] = col_index+1;
                }
                counter = counter + 1;
            }
        }
        return VerticalSeam;
    }

    public void removeHorizontalSeam(int[] seam) 
    {       
        if (seam == null)
        {
            throw new java.lang.NullPointerException();
        }
        if (seam.length != width()-1)
        {
            throw new java.lang.IllegalArgumentException();
        }
        if (height() <= 1 || width() <= 1)
        {
            throw new java.lang.IllegalArgumentException();
        }   
        for (int i = 1; i < seam.length; i++)
        {
            if (seam[i] - seam[i-1] > 1)
                {
                    throw new java.lang.IllegalArgumentException();
                }
        }
        for (int i = 0; i < seam.length; i++)
        {
            if (seam[i] > height()-1 || seam[i] < 0)
            {
                throw new java.lang.IllegalArgumentException();
            }
        }
        
        Picture old_image = picture();
        Picture new_image = new Picture(old_image.width(), old_image.height() - 1);
        
        for (int w = 0; w < new_image.width()-1; w++) 
        {
            for (int h = 0; h < seam[w]; h++) 
            {
                new_image.set(w, h, old_image.get(w, h));
            }
            for (int h = seam[w]; h < new_image.height(); h++) 
            {
                new_image.set(w, h, old_image.get(w, h + 1));
            }
        }
        System.out.println("old height: " + old_image.height());
        //System.out.println("old height: " + old_image.width());
        System.out.println("new height: " + new_image.height());
        //System.out.println("new height: " + new_image.width());
        this.picture = new_image;
    }

    
    public void removeVerticalSeam(int[] seam)
    {
        if (seam == null)
        {
            throw new java.lang.NullPointerException();
        }
        if (seam.length != height())
        {
            throw new java.lang.IllegalArgumentException();
        }
        if (height() <= 1 || width() <= 1)
        {
            throw new java.lang.IllegalArgumentException();
        }   
        for (int i = 1; i < seam.length; i++)
        {
            if (seam[i] - seam[i-1] > 1)
                {
                    throw new java.lang.IllegalArgumentException();
                }
        }
        for (int i = 0; i < seam.length; i++)
        {
            if (seam[i] > width() || seam[i] < 0)
            {
                throw new java.lang.IllegalArgumentException();
            }
        }
        
        Picture old_image = picture();
        //System.out.println(picture().height());
        //System.out.println(picture().width());
        Picture new_image = new Picture(old_image.width() - 1, old_image.height());
        
        for (int h = 0; h < new_image.height(); h++) 
        {
            for (int w = 0; w < seam[h]; w++) 
            {
                new_image.set(w, h, old_image.get(w, h));
            }
            for (int w = seam[h]; w < new_image.width(); w++) 
            {
                new_image.set(w, h, old_image.get(w + 1, h));
            }
        }
        //System.out.println("old height: " + old_image.height());
        System.out.println("old width: " + old_image.width());
        //System.out.println("new height: " + new_image.height());
        System.out.println("new width: " + new_image.width());
        this.picture = new_image;
    }

} 
