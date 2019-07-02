
--> For finding the vertical seam:
 - I picked the minimum element from the first row (i.e. row = 0)
 - Next, I compared its three neighbouring elements (column, column + 1, column - 1) in the next row (row = 1) and picked the minimum one.
 - I stored the column index of the minimum element in the verticalseam array.
 - Pixels at column = width()-1 and column = 0 were dealt with separately.

--> For removing the vertical seam: 
 - I created a new picture object with the same height as original image and width - 1
 - I copied the pixels from row = 0 to indices in the verticalseam array to the new image
 - Then skipping the pixels in verticalseam array, I copied the other set of pixels in the new image with 
	height of new image = height of old image + 1;

--> For finding the horizontal seam:
 - I picked the minimum element from the first column(i.e. column = 0)
 - Next, I compared its three neighbouring elements (row, row + 1, row - 1) in the next column (column = 1) and picked the minimum one.
 - I stored the row index of the minimum element in the horizontalseam array.
 - Pixels at row = height()-1 and row = 0 were dealt with separately.

--> For removing the horizontal seam: 
 - I created a new picture object with the same width as original image and height - 1
 - I copied the pixels from column = 0 to indices in the horizontalseam array to the new image
 - Then skipping the pixels in horizontalarray, I copied the other set of pixels in the new image with 
	width of new image = width of old image + 1;

--> Running Times:
 - Finding vertical seam: O(H)
 - Finding horizontal seam: O(W)
 - Removing vertical seam: O(WH)
 - Removing horizontal seam: O(WH)
 - Checking for exceptions and boundary conditions: O(constant)
 - Total Running Time: O(WH) where W = width of the image and H = height of the image