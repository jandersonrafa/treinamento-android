package com.example.jandersonrosa.trooper.util;

import com.example.jandersonrosa.trooper.R;
import com.example.jandersonrosa.trooper.model.Affiliation;

/**
 * Created by janderson.rosa on 18/11/2017.
 */

public class ResourceUtil {

    public static int getResourceBaseAndAffiliation(Affiliation affiliation) {
        switch (affiliation) {
            case FIRST_ORDER:
                return R.drawable.first_order;
            case GALACTIC_EMPIRE:
                return R.drawable.galactic_empire;
            case GALACTIC_REPUBLIC:
                return R.drawable.galactic_republic;
            default:
                return 0;
        }

    }
}
