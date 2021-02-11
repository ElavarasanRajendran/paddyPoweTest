package com.paddy.power.test.paddypowertest.service.impl;

import com.paddy.power.test.paddypowertest.common.Bet;
import com.paddy.power.test.paddypowertest.common.TotalLiability;
import com.paddy.power.test.paddypowertest.service.ReportService;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ReportServiceImpl implements ReportService {
    @Override
    public List<TotalLiability> generateTotalLiabilityReport(List<Bet> betList) {
        Map<String, List<Bet>> betMap = new HashMap<>();
        betList.forEach(bet -> {
            if(betMap.containsKey(bet.getCurrency())) {
                List<Bet> bets = betMap.get(bet.getCurrency());
                bets.add(bet);
                betMap.put(bet.getCurrency(), bets);
            } else {
                List<Bet> bets = new ArrayList<>();
                bets.add(bet);
                betMap.put(bet.getCurrency(), bets);
            }
        });

        List<TotalLiability> totalLiabilityList = new ArrayList<>();
        betMap.forEach((s, bets) -> {
            TotalLiability totalLiability = new TotalLiability();
            totalLiability.setCurrency(s);
            bets.stream().filter(Objects::nonNull)
                    .forEach( bet -> {
                        totalLiability.setNumberOfBets(totalLiability.getNumberOfBets()+1);
                        totalLiability.setTotalStakes(totalLiability.getTotalStakes()+ bet.getStake());
                        double liability =
                                totalLiability.getTotalLiabilities() + (bet.getStake() * bet.getPrice());
                        totalLiability.setTotalLiabilities(liability);
            });
            totalLiabilityList.add(totalLiability);
        });
        return totalLiabilityList;
    }
}
