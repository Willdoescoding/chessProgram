package chessProgram;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.LinkedList;
import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

public class chessProgram 
{
	/* Disclaimer: the following code is modified and inspired from other users too. The main 
	 * purpose of this project is to understand the concept of using JFrame, graphics and the concept
	 * of chess in Java 
	 * 
	 * References and sources
	 * YouTube
	 * WikiHow
	 * GitHub
	 * Javapoint
	 * 
	 */
	public static LinkedList<Pieces> piece =new LinkedList<>();
	public static Pieces selectPiece = null;
	
    public static void main(String[] args) throws IOException 
    {
       
        
        //implement a chess PNG image into the program 
        
        //try to use another chess piece design 
        BufferedImage png = ImageIO.read(new File("C:\\Users\\shiha\\Desktop\\My Own Project\\chessPieces.png"));
        
        Image imgs[] = new Image[12];
		int index = 0;
		
		//A for loop for drawing the chess board and squares. The board is 64 squares in total 
		for(int i = 0; i < 400; i += 200)
		{
			for(int j = 0; j < 1200; j += 200)
			{
				imgs[index] = png.getSubimage(j, i, 200, 200).getScaledInstance(64, 64, BufferedImage.SCALE_SMOOTH);
				index++;
			}
		}
		
      //*****Black Chess Pieces*****//
        
        //black rook
        Pieces blackRook = new Pieces(0, 0, false, "rook", piece);
        Pieces blackRook2 = new Pieces(7, 0, false, "rook", piece);
        
        //black knight
        Pieces blackKinght = new Pieces(1, 0, false, "knight", piece);
        Pieces blackKight2 = new Pieces(6, 0, false, "knight", piece);
        
        //black bishop
        Pieces blackBishop = new Pieces(2, 0, false, "bishop", piece);
        Pieces blackBishop2 = new Pieces(5, 0, false, "bishop", piece);
        
        //black queen
        Pieces blackQueen = new Pieces(3, 0, false, "queen", piece);
        //black king
        Pieces blackKing = new Pieces(4, 0, false, "king", piece);
        
        //black pawns 
        Pieces blackPawn1 = new Pieces(1, 1, false, "pawn", piece);
        Pieces blackPawn2 = new Pieces(2, 1, false, "pawn", piece);
        Pieces blackPawn3 = new Pieces(3, 1, false, "pawn", piece);
        Pieces blackPawn4 = new Pieces(4, 1, false, "pawn", piece);
        Pieces blackPawn5 = new Pieces(5, 1, false, "pawn", piece);
        Pieces blackPawn6 = new Pieces(6, 1, false, "pawn", piece);
        Pieces blackPawn7 = new Pieces(7, 1, false, "pawn", piece);
        Pieces blackPawn8 = new Pieces(0, 1, false, "pawn", piece);
        
        //*****White Chess Pieces*****//
            
        //white rook
        Pieces whiteRook = new Pieces(0, 7, true, "rook", piece);
        Pieces whiteRook2 = new Pieces(7, 7, true, "rook", piece);
        
        //white knight
        Pieces whiteKinght = new Pieces(1, 7, true, "knight", piece);
        Pieces whiteKight2 = new Pieces(6, 7, true, "knight", piece);
        
        //white bishop
        Pieces whiteBishop = new Pieces(2, 7, true, "bishop", piece);
        Pieces whiteBishop2 = new Pieces(5, 7, true, "bishop", piece);
        
        //white queen
        Pieces whiteQueen = new Pieces(3, 7, true, "queen", piece);
        //white king
        Pieces whiteKing = new Pieces(4, 7, true, "king", piece);
        
        //white pawns
        Pieces whitePawn1 = new Pieces(1, 6, true, "pawn", piece);
        Pieces whitePawn2 = new Pieces(2, 6, true, "pawn", piece);
        Pieces whitePawn3 = new Pieces(3, 6, true, "pawn", piece);
        Pieces whitePawn4 = new Pieces(4, 6, true, "pawn", piece);
        Pieces whitePawn5 = new Pieces(5, 6, true, "pawn", piece);
        Pieces whitePawn6 = new Pieces(6, 6, true, "pawn", piece);
        Pieces whitePawn7 = new Pieces(7, 6, true, "pawn", piece);
        Pieces whitePawn8 = new Pieces(0, 6, true, "pawn", piece);
        
        //using JFrame graphics for chess board
        JFrame win = new JFrame();
        win.setBounds(10, 10, 512, 512);
        win.setUndecorated(true);
        
        /*
         * WindowConstants.EXIT_ON_CLOSE - Closes the frame and terminates the execution of the program.
         * 
         * WindowConstants.DISPOSE_ON_CLOSE - Closes the frame and does not necessarily terminate the execution of the program.
         * 
         * WindowConstants.HIDE_ON_CLOSE - Makes the frame appear like it closed by setting its visibility property to false. 
         * 
         * The difference between HIDE_ON_CLOSE and DISPOSE_ON_CLOSE is that the latter releases all of the resources used by the frame and its components.
         * 
         * WindowConstants.DO_NOTHING_ON_CLOSE - Does nothing when the close button is pressed. Useful if you wish to, 
         * for example, display a confirmation dialog before the window is closed. 
         */
        
        
        //close chess program
        win.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
       
        win.addWindowListener(new WindowAdapter()
        {
        	@Override
        	public void windowClosing(WindowEvent e)
        	{
                // Asks the user before closing the program.
        		int option = JOptionPane.showConfirmDialog(win, 
        				"Do You Wish To Quit Chess? ",
        			"Close ", 
        			JOptionPane.YES_NO_OPTION, 
        			JOptionPane.QUESTION_MESSAGE);
        		
        		if (option == JOptionPane.YES_OPTION) 
        		{
        			System.exit(0);
        		}
        	}
        });
        
        
        JPanel panel = new JPanel()
        {
            @Override
            public void paint(Graphics board) 
            {
                boolean white = true;
                for(int i = 0; i < 10; i++)
                {
                    for(int j = 0; j < 10; j++)
                    {
                       if(white)
                       {
                          board.setColor(new Color(240,240,240)); //cream colour
                       }
                       else
                       {
                          board.setColor(new Color(0,204,0)); //green colour
                    
                       }
                          board.fillRect(i * 64, j * 64, 64, 64);
                          white =! white;
                    }
                          white =! white;
                }
                for(Pieces p: piece)
                {
                    int index = 0;
                    if(p.name.equalsIgnoreCase("king"))
                    {
                        index = 0;
                    }
                    if(p.name.equalsIgnoreCase("queen"))
                    {
                    	index = 1;
                    }
                    if(p.name.equalsIgnoreCase("bishop"))
                    {
                    	index = 2;
                    }
                    if(p.name.equalsIgnoreCase("knight"))
                    {
                    	index = 3;
                    }
                    if(p.name.equalsIgnoreCase("rook"))
                    {
                    	index = 4;
                    }
                    if(p.name.equalsIgnoreCase("pawn"))
                    {
                    	index = 5;
                    }
                    if(!p.isWhite)
                    {
                    	index += 6;
                    }
                    board.drawImage(imgs[index], p.p1, p.p2, this);
                }
            }
            
        };
        win.add(panel);
        win.addMouseListener(new MouseListener()
        {

        	
        	public void mousePressed(MouseEvent e) 
        	{
        		selectPiece = getPiece(e.getX(), e.getY());
        	}

        	public void mouseReleased(MouseEvent e) 
        	{
        		selectPiece.move(e.getX() / 64, e.getY() / 64);
        		win.repaint();
        	}

        	
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
        	
        });
        
        win.setDefaultCloseOperation(3);
        win.setVisible(true);
        
        win.addMouseMotionListener(new MouseMotionListener()
        {
			public void mouseDragged(MouseEvent e) 
			{
				if(selectPiece != null)
				{
					selectPiece.p1 = e.getX() -32;
					selectPiece.p2 = e.getY() -32;
					win.repaint();
					
				}
				
			}

			public void mouseMoved(MouseEvent e) 
			{

			}
        	
        });
        
        //window size 510 x 510 with title 
        win.setSize(510, 510);
        win.setTitle("Chess Program: Java Edition");
        win.getContentPane().add(panel, new chessProgram());
        win.setLocationRelativeTo(null);
        win.setBackground(Color.BLACK);
        win.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    public static Pieces getPiece(int p1, int p2)
    {
    	int piece1 = p1 / 64;
    	int piece2 = p2 / 64;
    	
    	for(Pieces p: piece)
    	{
    		if(p.piece1 == piece1 && p.piece2 == piece2)
    		{
    			return p;
    		}
    	}
    	return null;
    }
}

//Create the pieces: Pawn x8, Rook x2, Knight x2, Bishop x2, Queen x1, King x1 
class Pieces 
{
    int piece1;
    int piece2;
    
    int p1;
    int p2;
    
    boolean isWhite;
    LinkedList<Pieces> piece;
    String name;

    public Pieces(int piece1, int piece2, boolean isWhite,String pieceName, LinkedList<Pieces> piece) 
    {
        this.piece1 = piece1;
        this.piece2 = piece2;
        
        p1 = piece1 * 64;
        p2 = piece2 * 64;
        
        this.isWhite = isWhite;
        this.piece = piece;
        name = pieceName;
        piece.add(this);
    }
    
    public void move(int piece1,int piece2)
    {
    	//take out a piece when playing
    	if(chessProgram.getPiece(piece1 * 64, piece2 * 64) != null)
    	{
    		if(chessProgram.getPiece(piece1 * 64, piece2 * 64).isWhite != isWhite)
    		{
    			chessProgram.getPiece(piece1 * 64, piece2 * 64).take();
    		}
    		else
    		{
    			//return its piece's position
    			p1 = this.piece1 * 64;
    	        p2 = this.piece2 * 64;
    	        return;
    		}
    		
    	}
  
        this.piece1 = piece1;
        this.piece2 = piece2;
        
        p1 = piece1 * 64;
        p2 = piece2 * 64;
        
        
    }
    public void take()
    {
        piece.remove(this);
    }
}

