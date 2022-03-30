package com.example.a485project.data

import com.example.a485project.R

import com.example.a485project.model.Buy


class Datasource {

    var testlist = mutableListOf<Buy>(
        Buy(R.string.dish1, R.string.dish1_price, R.drawable.chickparm, R.string.Desc1, 3, R.string.Loc1 ),
        Buy(R.string.dish2, R.string.dish2_price, R.drawable.beefravi,R.string.Desc2, 5, R.string.Loc2),
        Buy(R.string.dish3, R.string.dish3_price, R.drawable.beefstrog,R.string.Desc3, 7, R.string.Loc3),
        Buy(R.string.dish4, R.string.dish4_price, R.drawable.bakesalm,R.string.Desc4, 21, R.string.Loc4),
        Buy(R.string.dish5, R.string.dish5_price, R.drawable.chicktikk,R.string.Desc5, 420, R.string.Loc5)
    )
    fun loadDish(): List<Buy>{
        return testlist
    }
}