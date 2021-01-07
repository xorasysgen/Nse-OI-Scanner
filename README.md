# JSR101-1.8.3.RELEASE # JSR101-2.0.1 RELEASE
## JSR101-USA Region
## JSR102-European Region
## JSR100.Backend

This is artificial intelligence created project powered by spring boot.System is designed on strategies derived from previous experiences with similar problems. It gives trading decision by making base of Trial and Error, educated guess, an intuitive judgment. Where finding an optimal solution is almost impossible or impractical, System methods are used to speed up the process of finding a satisfactory trading decision based on 40+ trading rules and discipline  i.e. INTRADAY OI SPURTS, OH-OL, GANN and Fibonacci level. System dashboard generates index & stock derivatives buy/sell level on basis of Open interest build up, Advance/Decline Ratio, buy/sell signal, Artificial intelligence based suggestion & trading range of Nifty and Bank Nifty etc.it also tracks USDINR, Dow Jones, crude oil. 

Heuristics can be mental shortcuts that ease the cognitive load of making a decision.So here Boot Heuristic Algorithm work for you.it is suitable for day-trader and a long-term investor too

# List of end points
```json
{
"service": [
{
"serviceID": 1,
"serviceURI": "/open_interest"
},
{
"serviceID": 2,
"serviceURI": "/top_gainer"
},
{
"serviceID": 3,
"serviceURI": "/top_looser"
},
{
"serviceID": 4,
"serviceURI": "/oi_spurts"
},
{
"serviceID": 5,
"serviceURI": "/fo_stocks"
},
{
"serviceID": 6,
"serviceURI": "/most_active_volume"
},
{
"serviceID": 7,
"serviceURI": "/most_active_value"
},
{
"serviceID": 8,
"serviceURI": "/indices"
},
{
"serviceID": 9,
"serviceURI": "/all_nifty_indices"
},
{
"serviceID": 10,
"serviceURI": "/advances_declines"
},
{
"serviceID": 11,
"serviceURI": "/advances_declines_bank_nifty"
},
{
"serviceID": 12,
"serviceURI": "/advances_declines_nifty"
},
{
"serviceID": 13,
"serviceURI": "/nifty_top_10_weightage_holdings"
},
{
"serviceID": 14,
"serviceURI": "/volume_gainers"
},
{
"serviceID": 15,
"serviceURI": "/most_active_intraday"
},
{
"serviceID": 16,
"serviceURI": "/derivative/bank_nifty_volume"
},
{
"serviceID": 17,
"serviceURI": "/derivative/call/call_all"
},
{
"serviceID": 18,
"serviceURI": "/derivative/call/call_nifty"
},
{
"serviceID": 19,
"serviceURI": "/derivative/call/call_nifty_bank"
},
{
"serviceID": 20,
"serviceURI": "/derivative/call/call_stocks"
},
{
"serviceID": 21,
"serviceURI": "/derivative/put/put_all"
},
{
"serviceID": 22,
"serviceURI": "/derivative/put/put_nifty"
},
{
"serviceID": 23,
"serviceURI": "/derivative/put/put_nifty_bank"
},
{
"serviceID": 24,
"serviceURI": "/derivative/put/put_stocks"
},
{
"serviceID": 25,
"serviceURI": "/oi_spurts_rise_oi_rise_price"
},
{
"serviceID": 26,
"serviceURI": "/oi_spurts_rise_in_price_slide_in_oi"
},
{
"serviceID": 27,
"serviceURI": "/oi_spurts_slide_in_price_rise_in_oi"
},
{
"serviceID": 28,
"serviceURI": "/oi_spurts_slide_in_price_slide_in_oi"
},
{
"serviceID": 29,
"serviceURI": "/security_wise_deliverable_positions_data"
},
{
"serviceID": 30,
"serviceURI": "/security_var"
},
{
"serviceID": 31,
"serviceURI": "/future_stocks_spike_value"
},
{
"serviceID": 32,
"serviceURI": "/future_stocks_spike_volume"
},
{
"serviceID": 33,
"serviceURI": "/option_chain_reader"
},
{
"serviceID": 34,
"serviceURI": "/option_chain_reader_all"
},
{
"serviceID": 35,
"serviceURI": "/option_chain_nifty"
},
{
"serviceID": 36,
"serviceURI": "/option_chain_stocks"
},
{
"serviceID": 37,
"serviceURI": "/top_20_contracts_nse_fo"
},
{
"serviceID": 38,
"serviceURI": "/nifty_50_Options"
},
{
"serviceID": 39,
"serviceURI": "/banknifty_option_chain_reader"
},
{
"serviceID": 40,
"serviceURI": "/banknifty_option_chain_nifty"
},
{
"serviceID": 41,
"serviceURI": "/most_active_securities_market_capitalisation"
},
{
"serviceID": 42,
"serviceURI": "/forthcoming_dividends"
},
{
"serviceID": 43,
"serviceURI": "/forthcoming_results"
},
{
"serviceID": 44,
"serviceURI": "/currency/usd_inr"
},
{
"serviceID": 45,
"serviceURI": "/currency/intraday_usd_inr_live"
},
{
"serviceID": 46,
"serviceURI": "/currency/dollar_index_brent_usd_inr"
},
{
"serviceID": 47,
"serviceURI": "/world_market_indices"
},
{
"serviceID": 48,
"serviceURI": "/nifty_future_oi"
},
{
"serviceID": 49,
"serviceURI": "/bank_nifty_future_oi"
},
{
"serviceID": 50,
"serviceURI": "/suggestions/bank_nifty_expiry_day_option_suggestion"
},
{
"serviceID": 51,
"serviceURI": "/suggestions/banknifty_and_nifty_support_resistance"
},
{
"serviceID": 52,
"serviceURI": "/suggestions/bank_nifty_expiry_day_option_suggestion/non_expiry_day"
},
{
"serviceID": 53,
"serviceURI": "/suggestions/bank_nifty_expiry_day_option_suggestion/aggressive_calls"
},
{
"serviceID": 54,
"serviceURI": "/suggestions/nifty_roadMap"
},
{
"serviceID": 55,
"serviceURI": "/suggestions/bank_nifty_roadMap"
},
{
"serviceID": 56,
"serviceURI": "/suggestions/premium_discount_nifty_banknifty"
},
{
"serviceID": 57,
"serviceURI": "/suggestions/nifty/ohl_strategy"
},
{
"serviceID": 58,
"serviceURI": "/suggestions/nifty/ohl_strategy/fo"
}
]
}
```


