package codeforces;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.*;

public class Problem5 {

    void solve() throws Exception
    {
        int n = nextInt();
        int[] p = new int[ n + 1 ];
        for( int i = 1; i <= n; i++ ) p[ i ] = nextInt();
        int[] q = new int[ n + 1 ];
        int[] cycle = new int[ n + 1 ];
        boolean[] was = new boolean[ n + 1 ];
        for( int i = 1; i <= n; i++ )
            if( !was[ i ] )
            {
                int len = 1;
                was[ i ] = true;
                for( int j = p[ i ]; j != i; j = p[ j ] )
                {
                    len++;
                    was[ j ] = true;
                }
                if( len % 2 == 1 )
                {
                    int j1 = i;
                    int j2 = i;
                    for( int j = 0; j <= len / 2; j++ ) j2 = p[ j2 ];
                    for( int j = 0; j <= len / 2; j++ )
                    {
                        q[ j1 ] = j2;
                        q[ j2 ] = p[ j1 ];
                        j1 = p[ j1 ];
                        j2 = p[ j2 ];
                    }
                }
                else
                {
                    if( cycle[ len ] == 0 )
                        cycle[ len ] = i;
                    else
                    {
                        int j1 = cycle[ len ];
                        int j2 = i;
                        for( int j = 0; j < len; j++ )
                        {
                            q[ j1 ] = j2;
                            q[ j2 ] = p[ j1 ];
                            j1 = p[ j1 ];
                            j2 = p[ j2 ];
                        }
                        cycle[ len ] = 0;
                    }
                }
            }
        boolean True = true;
        for( int i = 1; i <= n; i++ ) True &= q[ i ] != 0;
        if( True )
            for( int i = 1; i <= n; i++ ) out.print( q[ i ] + " " );
        else
            out.println( -1 );
    }

    public static void main( String[] args )
    {
        new Problem5().run();
    }

    public void run()
    {
        try
        {
            in = new BufferedReader( new InputStreamReader( System.in ) );
            out = new PrintWriter( System.out );
            solve();
        }
        catch( Exception e )
        {
            e.printStackTrace();
            System.exit( 1 );
        }
        finally
        {
            out.close();
        }
    }

    BufferedReader in;
    PrintWriter out;
    StringTokenizer st;

    String nextToken() throws IOException
    {
        while( st == null || !st.hasMoreTokens() ) st = new StringTokenizer( in.readLine() );
        return st.nextToken();
    }

    int nextInt() throws IOException
    {
        return Integer.parseInt( nextToken() );
    }

    long nextLong() throws IOException
    {
        return Long.parseLong( nextToken() );
    }

}