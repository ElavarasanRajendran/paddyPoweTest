package com.paddy.power.test.paddypowertest.service.impl;

import com.paddy.power.test.paddypowertest.common.dto.Bet;
import com.paddy.power.test.paddypowertest.common.dto.SelectionLiability;
import com.paddy.power.test.paddypowertest.common.dto.TotalLiability;
import com.paddy.power.test.paddypowertest.service.ReportService;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ReportServiceImpl implements ReportService {
    @Override
    public List<TotalLiability> generateTotalLiabilityReport(List<Bet> betList) {
        Map<String, List<Bet>> betMap = new HashMap<>();
        List<TotalLiability> totalLiabilityList = new ArrayList<>();

        betList.stream().filter(Objects::nonNull).forEach(bet -> {
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

    @Override
    public List<SelectionLiability> generateSelectionLiabilityReport(List<Bet> betList) {
        Map<String, Map<String, List<Bet>>> selectionLiabilityMap = new HashMap<>();
        betList.forEach( bet -> {
            if(selectionLiabilityMap.containsKey(bet.getSelectionName())) {
                Map<String, List<Bet>> currencyMap  = selectionLiabilityMap.get(bet.getSelectionName());
                List<Bet> bets;
                if(Objects.nonNull(currencyMap) &&
                        currencyMap.containsKey(bet.getCurrency())) {
                    bets = currencyMap.get(bet.getCurrency());
                    bets.add(bet);
                    currencyMap.put(bet.getCurrency(), bets);
                } else {
                    if( !Objects.nonNull(currencyMap)) {
                        currencyMap = new HashMap<>();
                    }
                    bets = new ArrayList<>();
                    bets.add(bet);
                    currencyMap.put(bet.getCurrency(), bets);
                }
            } else {
                Map<String, List<Bet>> betMap = new HashMap<>();
                List<Bet> bets = new ArrayList<>();
                bets.add(bet);
                betMap.put(bet.getCurrency(), bets);
                selectionLiabilityMap.put(bet.getSelectionName(), betMap);
            }
        });

        return this.generateLiabilityDetails(selectionLiabilityMap);
    }

    private List<SelectionLiability> generateLiabilityDetails(Map<String, Map<String, List<Bet>>> betsMap) {
        List<SelectionLiability> selectionLiabilities = new ArrayList<>();
        betsMap.forEach((selectionName, stringListMap) -> {
            stringListMap.forEach((currency, betList) -> {
                SelectionLiability selectionLiability = new SelectionLiability();
                betList.forEach(bet -> {
                    selectionLiability.setSelectionName(selectionName);
                    selectionLiability.setCurrency(currency);

                    int numberOfBets = selectionLiability.getNumberOfBets();
                    numberOfBets+=1;
                    selectionLiability.setNumberOfBets(numberOfBets);

                    double numberOfStacks = selectionLiability.getTotalStakes();
                    numberOfStacks+= bet.getStake();
                    selectionLiability.setTotalStakes(numberOfStacks);

                    double totalLiabilities = selectionLiability.getTotalLiabilities();
                    totalLiabilities = totalLiabilities + (bet.getStake() * bet.getPrice());
                    selectionLiability.setTotalLiabilities(totalLiabilities);
                });
                selectionLiabilities.add(selectionLiability);
            });
        });
        return selectionLiabilities;
    }
}
