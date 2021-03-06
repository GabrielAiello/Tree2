package com.example.darksword.tree;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import static java.lang.Integer.parseInt;

public class MainActivity extends AppCompatActivity
{
    private EditText ETenterval;
    private TextView TVdisplay;
    private Tree tree = new Tree();
    private String sillyString = "";

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.ETenterval = (EditText)this.findViewById(R.id.ETenterVal);
        this.TVdisplay = (TextView)this.findViewById(R.id.TVdisplay);
    }
    public void processButtonPressed (View v)
    {
        String s = ETenterval.getText().toString();
                //String.valueOf(ETenterval);
        //String alpha = "4";
        int b = parseInt(s);
        //int b = parseInt(ETenterval.toString());
        this.tree.treeRecursion(b);
        sillyString = sillyString + b;
        TVdisplay.setText(sillyString);
    }
    public String stringifyThatTree(Tree t)
    {
        Tree runner = t;
        String concatonationIsFun = "";
        while(runner.getPayload() != -1)
        {
            concatonationIsFun = concatonationIsFun + runner.getPayload();
            runner = runner.getNextTree();
        }
        return "";
    }
    public void balanceCheckButtonPressed(View v)
    {
        int leftDepth = 0;
        int rightDepth = 0;
        if (tree.getPreviousTree() != null)
        {
            leftDepth = tree.getPreviousTree().depthCheck();
        }
        if (tree.getNextTree()!= null)
        {
            rightDepth = tree.getNextTree().depthCheck();
        }
        if (rightDepth > leftDepth + 1)
        {
            TVdisplay.setText("the right side has greater depth and is out of balance");
        }
        else if (rightDepth + 1 < leftDepth)
        {
            TVdisplay.setText("the left side has greater depth and is out of balance");
        }
        else if (rightDepth > leftDepth)
        {
            TVdisplay.setText("the right side has greater depth but is balanced");
        }
        else if (rightDepth < leftDepth)
        {
            TVdisplay.setText("the left side has greater depth but is balanced");
        }
        else
            {
                TVdisplay.setText("they are balanced");
            }

    }
}
