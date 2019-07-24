
import java.util.*;
class Board
{
    public char board[][] = new char[20][20];
    public int hasharr[] = new int[20];


        // Stack<Character> stackobj = new Stack<Character>();
        Board()
        {
            for(int i=0;i<20;i++)
            {
                for(int j=0;j<20;j++)
                {
                    if(i==0||j==0||i==19||j==19)
                    board[i][j] ='*';
                    else
                    board[i][j] = ' ';
                }
            }
            for(int i=0;i<20;i++)
            {
                hasharr[i]=0;
            }

        }
        public void displayBoard()
        {
            // System.out.println("\033\143");
            for(int i=0;i<20;i++)
            {
                for(int j=0;j<20;j++)
                {
                    System.out.print(board[i][j]);
                }
                System.out.print("\n");
            }
            System.out.print("\n");
            for(int i=0;i<20;i++)
            {
                System.out.print(hasharr[i]+" ");
            }
            System.out.print("\n");
        }
}

class MyStack
{
    public char shape;
    public int lastx;
    public int lasty;
    public int version;
}

abstract class parentShapeClass
{

    public int x,y,version;
    public int xcord[] = new int[4];
    public int ycord[] = new int[4];

    abstract public void clockWiseRotate(Board bobj);
    abstract public void anticlockwiseRotate(Board bobj);
    parentShapeClass(){}

    // public void anticlockwiseRotate(Board bobj);
    // public void clockWiseRotate(Board bobj);
    public void moveRight(Board bobj)
    {
        int tempx[] = new int[4];
        int tempy[] = new int[4];
        //bobj.clearBoard();

        for(int i=0;i<4;i++)
        {
            tempx[i] = xcord[i];
            tempy[i] = ycord[i];
            bobj.board[xcord[i]][ycord[i]]=' ';
        }
        for(int i=0;i<4;i++)
        {
            ycord[i] = ycord[i]+1;
        }
        for(int i=0;i<4;i++)
        {
            if(bobj.board[xcord[i]][ycord[i]]!=' ')
            {
                for(int j=0;j<4;j++)
                {
                    xcord[j] = tempx[j];
                    ycord[j] = tempy[j];
                }
                break;
            }
        }

        for(int i=0;i<4;i++)
        {
            bobj.board[xcord[i]][ycord[i]]='#';
        }
    }
    public void moveLeft(Board bobj)
    {
        int tempx[] = new int[4];
        int tempy[] = new int[4];
        //bobj.clearBoard();

        for(int i=0;i<4;i++)
        {
            tempx[i] = xcord[i];
            tempy[i] = ycord[i];
            bobj.board[xcord[i]][ycord[i]]=' ';
        }
        for(int i=0;i<4;i++)
        {
            ycord[i] = ycord[i]-1;
        }
        for(int i=0;i<4;i++)
        {
            if(bobj.board[xcord[i]][ycord[i]]!=' ')
            {
                for(int j=0;j<4;j++)
                {
                    xcord[j] = tempx[j];
                    ycord[j] = tempy[j];
                }
                break;
            }
        }

        for(int i=0;i<4;i++)
        {
            bobj.board[xcord[i]][ycord[i]]='#';
        }

    }
    public void moveUp(Board bobj)
    {
        int tempx[] = new int[4];
        int tempy[] = new int[4];
        //bobj.clearBoard();

        for(int i=0;i<4;i++)
        {
            tempx[i] = xcord[i];
            tempy[i] = ycord[i];
            bobj.board[xcord[i]][ycord[i]]=' ';
        }
        for(int i=0;i<4;i++)
        {
            xcord[i] = xcord[i]-1;
        }
        for(int i=0;i<4;i++)
        {
            if(bobj.board[xcord[i]][ycord[i]]!=' ')
            {
                for(int j=0;j<4;j++)
                {
                    xcord[j] = tempx[j];
                    ycord[j] = tempy[j];
                }
                break;
            }
        }

        for(int i=0;i<4;i++)
        {
            bobj.board[xcord[i]][ycord[i]]='#';
        }
    }
    public int moveDown(Board bobj)
    {
        int tempx[] = new int[4];
        int tempy[] = new int[4];
        //bobj.clearBoard();


        for(int i=0;i<4;i++)
        {
            tempx[i] = xcord[i];
            tempy[i] = ycord[i];
            bobj.board[xcord[i]][ycord[i]]=' ';
        }
        for(int i=0;i<4;i++)
        {
            xcord[i] = xcord[i]+1;
        }
        for(int i=0;i<4;i++)
        {
            System.out.println("IN FOR");

            if(bobj.board[xcord[i]][ycord[i]]!=' ')
            {
                System.out.println("IN IF");

                for(int j=0;j<4;j++)
                {
                    bobj.board[tempx[j]][tempy[j]]='#';

                    xcord[j] = tempx[j];
                    ycord[j] = tempy[j];
                    bobj.hasharr[xcord[j]]++;
                }
                // for(int c=0;c<20;c++)
                // {
                //     if(bobj.hasharr[c]==18)
                //     {
                //         for(int k= c;k>1;k--)
                //         {
                //             for(int j=1;j<19;j++)
                //             {
                //                 bobj.board[k][j] = bobj.board[k-1][j];
                //             }
                //         }
                //         for(int j=c;j>0;j--)
                //         {
                //             bobj.hasharr[j]=bobj.hasharr[j-1];
                //         }
                //     }
                // }
                return 0;

            }
        }
        for(int i=0;i<4;i++)
        {
            bobj.board[xcord[i]][ycord[i]]='#';
        }
        return 1;
        // for(int i=0;i<4;i++)
        // {
        //     if(bobj.board[xcord[i]][ycord[i]]!=' ')
        //     {
        //         for(int j=0;j<4;j++)
        //         {
        //             bobj.board[tempx[j]][tempy[j]]='#';
        //             xcord[j] = tempx[j];
        //             ycord[j] = tempy[j];
        //         }
        //         break;
        //     }
        // }
    }

}
class Lshape extends parentShapeClass
{


    void createVersionOne(int xstart,int ystart)
    {
        xcord[0] = xstart;
        ycord[0] = ystart;
        for(int i=1;i<4;i++)
        ycord[i] = ystart+1;
        xcord[1] = xcord[0];
        xcord[2] = xcord[1]+1;
        xcord[3] = xcord[2]+1;
    }
    void createVersionTwo(int xstart,int ystart)
    {
        xcord[0] = xstart;
        ycord[0] = ystart;
        xcord[1] = xcord[0]+1;
        ycord[1] = ystart;
        xcord[2] = xcord[1]+1;
        ycord[2] = ystart;
        xcord[3] = xcord[2];
        ycord[3] = ystart - 1;
    }
    void createVersionThree(int xstart,int ystart)
    {
        xcord[0] = xstart;
        ycord[0] = ystart;
        xcord[1] = xstart;
        ycord[1] = ycord[0]-1;
        xcord[2] = xstart;
        ycord[2] = ycord[1]-1;
        xcord[3] = xcord[2]-1;
        ycord[3] = ycord[2];
    }
    void createVersionFour(int xstart,int ystart)
    {
        xcord[0] = xstart;
        ycord[0] = ystart;
        xcord[1] = xcord[0]-1;
        ycord[1] = ystart;
        xcord[2] = xcord[1]-1;
        ycord[2] = ystart;
        xcord[3] = xcord[2];
        ycord[3] = ystart+1;
    }
    public void clockWiseRotate(Board bobj)
    {
        version = version%4 + 1;

        int tempx[] = new int[4];
        int tempy[] = new int[4];

        for(int i=0;i<4;i++)
        {
            tempx[i] = xcord[i];
            tempy[i] = ycord[i];
            bobj.board[xcord[i]][ycord[i]]=' ';

        }

        if(version == 1)
        createVersionOne(xcord[0],ycord[0]);
        else if(version == 2)
        createVersionTwo(xcord[0],ycord[0]);
        else if(version == 3)
        createVersionThree(xcord[0],ycord[0]);
        else if(version==4)
        createVersionFour(xcord[0],ycord[0]);

        for(int i=0;i<4;i++)
        {
            if(bobj.board[xcord[i]][ycord[i]]!=' ')
            {
                for(int j=0;j<4;j++)
                {
                    xcord[j] = tempx[j];
                    ycord[j] = tempy[j];
                }
                break;
            }
        }

        for(int i=0;i<4;i++)
        {
            bobj.board[xcord[i]][ycord[i]]='#';
        }



    }
    public void anticlockwiseRotate(Board bobj)
    {
        if(version == 1)
        version = 4;
        else
        version = version - 1;

        int tempx[] = new int[4];
        int tempy[] = new int[4];

        for(int i=0;i<4;i++)
        {
            tempx[i] = xcord[i];
            tempy[i] = ycord[i];
            bobj.board[xcord[i]][ycord[i]]=' ';
        }


        if(version == 1)
        createVersionOne(xcord[0],ycord[0]);
        else if(version == 2)
        createVersionTwo(xcord[0],ycord[0]);
        else if(version == 3)
        createVersionThree(xcord[0],ycord[0]);
        else if(version==4)
        createVersionFour(xcord[0],ycord[0]);

        for(int i=0;i<4;i++)
        {
            if(bobj.board[xcord[i]][ycord[i]]!=' ')
            {
                for(int j=0;j<4;j++)
                {
                    xcord[j] = tempx[j];
                    ycord[j] = tempy[j];
                }
                break;
            }
        }

        for(int i=0;i<4;i++)
        {
            bobj.board[xcord[i]][ycord[i]]='#';
        }


    }
    Lshape(int reqversion,Board bobj,int x,int y)
    {
        // x = 4;
        // y = 10;
        this.x = x;
        this.y =y;
        version = reqversion;
        if(reqversion == 1)
            createVersionOne(x,y);
        else if(reqversion == 2)
            createVersionTwo(x,y);
        else if(reqversion == 3)
            createVersionThree(x,y);
        else if(reqversion == 4)
            createVersionFour(x,y);

            for(int i=0;i<4;i++)
            {
                bobj.board[xcord[i]][ycord[i]]='#';
            }

    }
}
class LineShape extends parentShapeClass
{
    LineShape(int reqversion,Board bobj,int x,int y)
    {
        // x = 4;
        // y = 10;
        this.x = x;
        this.y = y;
        version = reqversion;
        if(reqversion == 1)
        {
            createVersionOne(x,y);
        }
        else if(reqversion == 2)
        {
            createVersionTwo(x,y);
        }
        for(int i=0;i<4;i++)
        {
            bobj.board[xcord[i]][ycord[i]]='#';
        }
    }

    public void createVersionOne(int xstart,int ystart)
    {
        xcord[0] = xstart;
        ycord[0] = ystart;
        for(int i=1;i<4;i++)
        xcord[i] = xstart;
        for(int i=1;i<4;i++)
        ycord[i] =  ycord[i-1]+1;
    }
    public void createVersionTwo(int xstart,int ystart)
    {
        xcord[0] = xstart;
        ycord[0] = ystart;
        for(int i=1;i<4;i++)
        xcord[i] = xcord[i-1]+1;
        for(int i=1;i<4;i++)
        ycord[i] = ystart;
    }
    public void clockWiseRotate(Board bobj)
    {
        version = version%2 + 1;

        int tempx[] = new int[4];
        int tempy[] = new int[4];


        for(int i=0;i<4;i++)
        {
            tempx[i] = xcord[i];
            tempy[i] = ycord[i];
            bobj.board[xcord[i]][ycord[i]]=' ';
        }

        if(version == 1)
        createVersionOne(xcord[0],ycord[0]);
        else if(version == 2)
        createVersionTwo(xcord[0],ycord[0]);

        for(int i=0;i<4;i++)
        {
            if(bobj.board[xcord[i]][ycord[i]]!=' ')
            {
                for(int j=0;j<4;j++)
                {
                    xcord[j] = tempx[j];
                    ycord[j] = tempy[j];
                }
                break;
            }
        }
        for(int i=0;i<4;i++)
        {
            bobj.board[xcord[i]][ycord[i]]='#';
        }

    }
    public void anticlockwiseRotate(Board bobj)
    {
        if(version==1)
        version = 2;
        else
        version = version - 1;

        int tempx[] = new int[4];
        int tempy[] = new int[4];

        for(int i=0;i<4;i++)
        {
            tempx[i] = xcord[i];
            tempy[i] = ycord[i];
            bobj.board[xcord[i]][ycord[i]]=' ';
        }
        if(version == 1)
            createVersionOne(xcord[0],ycord[0]);
        else if(version == 2)
            createVersionTwo(xcord[0],ycord[0]);

            for(int i=0;i<4;i++)
            {
                if(bobj.board[xcord[i]][ycord[i]]!=' ')
                {
                    for(int j=0;j<4;j++)
                    {
                        xcord[j] = tempx[j];
                        ycord[j] = tempy[j];
                    }
                    break;
                }
            }

            for(int i=0;i<4;i++)
            {
                bobj.board[xcord[i]][ycord[i]]='#';
            }
    }

}
// T APED CLASSS
class Tshape extends parentShapeClass
{

    public void createVersionOne(int xstart,int ystart)
    {
        xcord[0] = xstart;
        ycord[0] = ystart;
        xcord[1] = xstart-1;
        ycord[1] = ycord[0];
        xcord[2] = xstart-1;
        ycord[2] = ycord[1]+1;
        xcord[3] = xstart-1;
        ycord[3] = ycord[1]-1;
    }
    public void createVersionTwo(int xstart,int ystart)
    {
        xcord[0] = xstart;
        ycord[0] = ystart;
        xcord[1] = xstart - 1;
        ycord[1] = ystart+1;
        xcord[2] = xcord[1]+1;
        ycord[2] = ystart+1;
        xcord[3] = xcord[2]+1;
        ycord[3] = ystart+1;
    }

    public void createVersionThree(int xstart,int ystart)
    {
        xcord[0] = xstart;
        ycord[0] = ystart;
        xcord[1] = xstart+1;
        ycord[1] = ystart;
        xcord[2] = xstart + 1;
        ycord[2] = ycord[1]-1;
        xcord[3] = xstart +1;
        ycord[3] = ycord[1]+1;
    }
    public void createVersionFour(int xstart,int ystart)
    {
        xcord[0] = xstart;
        ycord[0] = ystart;
        xcord[1] = xstart;
        ycord[1] = ystart-1;
        xcord[2] = xcord[1]-1;
        ycord[2] = ystart-1;
        xcord[3] = xcord[1]+1;
        ycord[3] =ystart-1;
    }
    public void clockWiseRotate(Board bobj)
    {
        version = version%4 + 1;

        int tempx[] = new int[4];
        int tempy[] = new int[4];

        for(int i=0;i<4;i++)
        {
            tempx[i] = xcord[i];
            tempy[i] = ycord[i];
            bobj.board[xcord[i]][ycord[i]]=' ';
        }

        if(version == 1)
        createVersionOne(xcord[0],ycord[0]);
        else if(version == 2)
        createVersionTwo(xcord[0],ycord[0]);
        else if(version == 3)
        createVersionThree(xcord[0],ycord[0]);
        else if(version==4)
        createVersionFour(xcord[0],ycord[0]);

        for(int i=0;i<4;i++)
        {
            if(bobj.board[xcord[i]][ycord[i]]!=' ')
            {
                for(int j=0;j<4;j++)
                {
                    xcord[j] = tempx[j];
                    ycord[j] = tempy[j];
                }
                break;
            }
        }

        for(int i=0;i<4;i++)
        {
            bobj.board[xcord[i]][ycord[i]]='#';
        }

    }
    public void anticlockwiseRotate(Board bobj)
    {
        if(version == 1)
        version = 4;
        else
        version = version - 1;

        int tempx[] = new int[4];
        int tempy[] = new int[4];

        for(int i=0;i<4;i++)
        {
            tempx[i] = xcord[i];
            tempy[i] = ycord[i];
            bobj.board[xcord[i]][ycord[i]]=' ';
        }

        if(version == 1)
        createVersionOne(xcord[0],ycord[0]);
        else if(version == 2)
        createVersionTwo(xcord[0],ycord[0]);
        else if(version == 3)
        createVersionThree(xcord[0],ycord[0]);
        else if(version==4)
        createVersionFour(xcord[0],ycord[0]);

        for(int i=0;i<4;i++)
        {
            if(bobj.board[xcord[i]][ycord[i]]!=' ')
            {
                for(int j=0;j<4;j++)
                {
                    xcord[j] = tempx[j];
                    ycord[j] = tempy[j];
                }
                break;
            }
        }

        for(int i=0;i<4;i++)
        {
            bobj.board[xcord[i]][ycord[i]]='#';
        }


    }


    Tshape(int reqversion,Board bobj,int x,int y)
    {
        // x = 4;
        // y = 10;
        this.x = x;
        this.y = y;
        version = reqversion;
        if(reqversion == 1)
            createVersionOne(x,y);
        else if(reqversion == 2)
            createVersionTwo(x,y);
        else if(reqversion == 3)
            createVersionThree(x,y);
        else if(reqversion == 4)
            createVersionFour(x,y);

            for(int i=0;i<4;i++)
            {
                bobj.board[xcord[i]][ycord[i]]='#';
            }

    }
}

class Square
{
    public int x,y,version;
    public int xcord[] = new int[4];
    public int ycord[] = new int[4];

    public void createSquare(int xstart,int ystart)
    {
        xcord[0] = xstart;
        ycord[0] = ystart;
        xcord[1] = xstart;
        ycord[1] = ystart+1;
        xcord[2] = xstart+1;
        ycord[2] = ystart;
        xcord[3] = xstart+1;
        ycord[3]  = ystart+1;
     }
    Square(int reqversion)
    {
        x = 4;
        y = 10;
        version = reqversion;
        createSquare(x,y);
    }
}
class Zshape extends parentShapeClass
{

    public void createVersionOne(int xstart,int ystart)
    {
        xcord[0] = xstart;
        ycord[0] = ystart;
        xcord[1] = xstart;
        ycord[1] = ycord[0]+1;
        xcord[2] = xstart+1;
        ycord[2] = ycord[1];
        xcord[3] = xcord[2];
        ycord[3] = ycord[2]+1;
    }
    public void createVersionTwo(int xstart,int ystart)
    {
        xcord[0] = xstart;
        ycord[0] = ystart;
        xcord[1] = xstart+1;
        ycord[1] = ystart;
        xcord[2] = xcord[1];
        ycord[2] = ystart-1;
        xcord[3] = xcord[2]+1;
        ycord[3] = ystart-1;
    }
    public void clockWiseRotate(Board bobj)
    {
        version = version%2+ 1;

        int tempx[] = new int[4];
        int tempy[] = new int[4];

        for(int i=0;i<4;i++)
        {
            tempx[i] = xcord[i];
            tempy[i] = ycord[i];
            bobj.board[xcord[i]][ycord[i]]=' ';
        }

        if(version == 1)
        createVersionOne(xcord[0],ycord[0]);
        else if(version == 2)
        createVersionTwo(xcord[0],ycord[0]);

        for(int i=0;i<4;i++)
        {
            if(bobj.board[xcord[i]][ycord[i]]!=' ')
            {
                for(int j=0;j<4;j++)
                {
                    xcord[j] = tempx[j];
                    ycord[j] = tempy[j];
                }
                break;
            }
        }

        for(int i=0;i<4;i++)
        {
            bobj.board[xcord[i]][ycord[i]]='#';
        }

    }
    public void anticlockwiseRotate(Board bobj)
    {
        if(version == 1)
        version = 2;
        else
        version = version - 1;

        int tempx[] = new int[4];
        int tempy[] = new int[4];

        for(int i=0;i<4;i++)
        {
            tempx[i] = xcord[i];
            tempy[i] = ycord[i];
            bobj.board[xcord[i]][ycord[i]]=' ';
        }

        if(version == 1)
        createVersionOne(xcord[0],ycord[0]);
        else if(version == 2)
        createVersionTwo(xcord[0],ycord[0]);

        for(int i=0;i<4;i++)
        {
            if(bobj.board[xcord[i]][ycord[i]]!=' ')
            {
                for(int j=0;j<4;j++)
                {
                    xcord[j] = tempx[j];
                    ycord[j] = tempy[j];
                }
                break;
            }
        }

        for(int i=0;i<4;i++)
        {
            bobj.board[xcord[i]][ycord[i]]='#';
        }
    }

    Zshape(int reqversion,Board bobj,int x,int y)
    {
        // x = 4;
        // y = 10;
        this.x = x;
        this.y = y;
        version = reqversion;
        if(reqversion == 1)
        createVersionOne(x,y);
        else if(reqversion == 2)
        createVersionTwo(x,y);

        for(int i=0;i<4;i++)
        {
            bobj.board[xcord[i]][ycord[i]]='#';
        }
    }
}

public class Tgame
{

    void makeShape(int turn,Board bobj,Stack<Character> movestackobj,Stack<MyStack> shapestackobj)
    {
        parentShapeClass parentobj ;
        if(turn == 1)
        parentobj =  new LineShape(1,bobj,4,10);
        else if(turn == 2)
        parentobj = new Tshape(1,bobj,4,10);
        else if(turn == 3)
        parentobj = new Zshape(1,bobj,4,10);
        else
        parentobj =  new Lshape(1,bobj,4,10);

        Scanner sc = new Scanner(System.in);
        char keypress;
        bobj.displayBoard();

        while(true)
        {
            keypress = sc.next().charAt(0);
            if(keypress != 'z')
            movestackobj.push(keypress);

            if(keypress == 'c')
            parentobj.clockWiseRotate(bobj);
            else if(keypress == 'a')
            parentobj.anticlockwiseRotate(bobj);
            else if(keypress == 'r')
            parentobj.moveRight(bobj);
            else if(keypress == 'l')
            parentobj.moveLeft(bobj);
            else if(keypress == 'z' && !movestackobj.empty())
            {
                char ch = movestackobj.pop();
                if(ch=='$')
                {
                    for(int i=0;i<4;i++)
                    {
                        bobj.board[parentobj.xcord[i]][parentobj.ycord[i]]=' ';
                    }
                    if(!shapestackobj.empty())
                    {
                        MyStack popobject = shapestackobj.pop();
                        if(popobject.shape == 'i')
                        {parentobj = new LineShape(popobject.version,bobj,popobject.lastx,popobject.lasty);
                        turn =1 ; // agr ye nhi kruga toh stckentry mein problem aygi ki object niche se T shape ka aya tha turn 2 thi but z operation k karn line object dobara bnna therfore turn needs to be changed so that correct entry is made in stack
                        }
                        else if(popobject.shape == 't')
                        {parentobj = new Tshape(popobject.version,bobj,popobject.lastx,popobject.lasty);
                        turn =2;
                        }
                        else if(popobject.shape == 'z')
                        {parentobj = new Zshape(popobject.version,bobj,popobject.lastx,popobject.lasty);
                        turn =3;
                        }
                        else
                        {parentobj = new Lshape(popobject.version,bobj,popobject.lastx,popobject.lasty);
                        turn = 4 ;
                        }

                        // this loop is to change the hasharr values as the shapes are leaving the board
                        for(int i=0;i<4;i++)
                        {
                            bobj.hasharr[parentobj.xcord[i]] -=1;
                        }
                        continue;
                    }
                    else
                    {
                        return ;
                    }

                }
                if(ch=='c')
                parentobj.anticlockwiseRotate(bobj);
                else if(ch=='a')
                parentobj.clockWiseRotate(bobj);
                else if(ch=='r')
                parentobj.moveLeft(bobj);
                else if(ch=='l')
                parentobj.moveRight(bobj);
                else if(ch=='d')
                parentobj.moveUp(bobj);
                else if(ch=='-')
                {
                    for(int i=0;i<4;i++)
                    {
                        bobj.board[parentobj.xcord[i]][parentobj.ycord[i]]=' ';
                    }

                    MyStack popline = shapestackobj.pop();
                    int xindex = popline.lastx;
                    for(int k= 2;k<=xindex;k++)
                    {
                        for(int j=1;j<19;j++)
                        {
                            bobj.board[k-1][j] = bobj.board[k][j];
                        }
                    }
                    for(int j=2;j<=xindex;j++)
                    {
                        bobj.hasharr[j-1]=bobj.hasharr[j];
                    }
                    bobj.hasharr[xindex]=18;
                    for(int j=1;j<19;j++)
                    {
                        bobj.board[xindex][j]='#';
                    }
                }

            }
            else if(keypress == 'd')
            {
                if(parentobj.moveDown(bobj) == 0)
                {
                    System.out.println(parentobj.xcord[0] );
                    System.out.println(parentobj.ycord[0]);
                    System.out.println(parentobj.version);

                    movestackobj.push('$');
                    MyStack mystackobj = new MyStack();
                    if(turn == 1)
                    mystackobj.shape = 'i';
                    else if(turn == 2)
                    mystackobj.shape = 't';
                    else if(turn == 3)
                    mystackobj.shape = 'z';
                    else
                    mystackobj.shape = 'l';

                    mystackobj.lastx = parentobj.xcord[0];
                    mystackobj.lasty = parentobj.ycord[0];
                    mystackobj.version = parentobj.version;

                    shapestackobj.push(mystackobj);

                    // Maintaining the hash array
                    for(int c=0;c<20;c++)
                    {
                        if(bobj.hasharr[c]==18)
                        {
                            for(int k= c;k>1;k--)
                            {
                                for(int j=1;j<19;j++)
                                {
                                    bobj.board[k][j] = bobj.board[k-1][j];
                                }
                            }
                            for(int j=c;j>0;j--)
                            {
                                bobj.hasharr[j]=bobj.hasharr[j-1];
                            }
                            movestackobj.push('-');
                            MyStack linerev = new MyStack();
                            linerev.shape = '-';
                            linerev.lastx = c;
                            linerev.lasty = 0;
                            linerev.version = 0;
                            shapestackobj.push(linerev);
                        }
                    }

                    return;
                }
            }
            bobj.displayBoard();
        }
    }
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        Board bobj = new Board();
        bobj.displayBoard();
        Tgame tetris = new Tgame();

        Stack<Character> movestackobj = new Stack<Character>();
        Stack<MyStack> shapestackobj = new Stack<MyStack>();
        while(true)
        {
            tetris.makeShape(1,bobj,movestackobj,shapestackobj);
            tetris.makeShape(2,bobj,movestackobj,shapestackobj);
            tetris.makeShape(3,bobj,movestackobj,shapestackobj);
            tetris.makeShape(4,bobj,movestackobj,shapestackobj);
        }

    }
}
