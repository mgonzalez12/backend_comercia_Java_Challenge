package com.tech.apicomerciatech.application.services.utlis;

import com.tech.apicomerciatech.infrastruture.adapter.entity.Games;

import java.math.BigDecimal;

import static com.tech.apicomerciatech.domain.constant.MessageContant.NULLABLE_ENUM;

public class Calculos {
    public static Double calculateBasePrice(Games game) {
        if (game.getType() == NULLABLE_ENUM) {
            throw new IllegalArgumentException("Game type cannot be null");
        }
        switch (game.getType()) {
            case NEW_RELEASE:
                return game.getPremiumPrice();
            case STANDARD_GAME:
                return game.getBasicPrice();
            case CLASSIC_GAME:
                return game.getBasicPrice();
            default:
                throw new RuntimeException("Invalid game type");
        }
    }

    public static double calculateTotalPrice(int requestedDays, BigDecimal basePrice, Games game) {
        if (requestedDays <= 0) {
            throw new IllegalArgumentException("Requested rental days must be positive");
        }
        switch (game.getType()) {
            case NEW_RELEASE:
                return requestedDays * basePrice.doubleValue();
            case STANDARD_GAME:
                return (requestedDays <= 3) ? requestedDays * basePrice.doubleValue() : (3 * basePrice.doubleValue()) + ((requestedDays - 3) * basePrice.doubleValue());
            case CLASSIC_GAME:
                return (requestedDays <= 5) ? requestedDays * basePrice.doubleValue() : (5 * basePrice.doubleValue()) + ((requestedDays - 5) * basePrice.doubleValue());
            default:
                throw new RuntimeException("Invalid game type");
        }
    }
}
