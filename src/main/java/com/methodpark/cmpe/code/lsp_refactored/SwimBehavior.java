package com.methodpark.cmpe.code.lsp_refactored;

//public class SwimBehavior implements IDuckBehavior
public class SwimBehavior extends DuckBehavior
{

    @Override
    public void Perform()
    {
        System.out.println( name + ": splash splash");
    }

}
