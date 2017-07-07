package ru.kraftlab.web.web.dto.validate;

import ru.kraftlab.web.web.dto.request.CampaignDTO;

import static com.google.common.base.Strings.isNullOrEmpty;

/**
 * Created by Мария on 28.06.2017.
 */
public class CampaignValidator {

    public static void validateNew(CampaignDTO campaign) throws IllegalArgumentException {
        String errMessage = "";
        if (isNullOrEmpty(campaign.getName())) {
            errMessage = String.join("Не задано название кампании.");
        }
        if (isNullOrEmpty(campaign.getFileName())) {
            errMessage = String.join(" ", errMessage, "Не задан путь к обучающими материалам.");
        }

        if (!isNullOrEmpty(errMessage)) {
            throw new IllegalArgumentException(errMessage);
        }
    }
}
