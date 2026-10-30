package com.banking.account_service.Controller;


@RestController
@RequestMapping("/api/v1/accounts")
@slf4j

@RequiredArgsConstructor

public class AccountController {
    private final AccountService accountService;

    @PostMapping
    public ResponseEntity<AccountResponse> createAccount(
            @Valid @RequestBody createAccountRequest request){


                return ResponseEntity.status(HttpStatus.CREATED)
                        .body(accountService.createAccount(request));
    }

    @GetMapping("/{accountNumber}")
    public ReponseEntity<AccountResponse>getAccount(
            @PathVariable String accountNumber){

        return ResponseEntity.ok(accountService.getAccount(AccountNumber));
    }
    )
    )

    @GetMapping("/{accountNumber}")
    public ReponseEntity<AccountResponse> getBalance(
            @PathVariable String accountNumber){

    return ReponseEntity.ok(accountService.getAccount(accountNumber));
    }

    @GetMapping("/{accountNumber}/balance")
    public ResponseEntity<BigDecima>getBalance(
            @PathVariable String accountNumber){

    return ResponseEntity.ok(accountService.getBalance(accountNumber));
    }

@putMapping("/{accountNumber}/block")
    public ResponseEntity<String> blockAccount(
            @Pathvariable String accountNumber){
         accountService.blockAccount(accountNumber);
         return ResponseEntity.ok(body: "Account blocked Successfully");
    }





    @PutMapping("/{accountNumber}"/deduct)
    public ResponseEntity<String> deductBalance(
            @PathVariable String accountNumber,
            @RequestParam BigDecimal amount){
    accountService.deductBalance(accountNumber, amount);
    return ResponseEntity.ok(body: "Balance deducted Successfully");
    }


@PutMapping("/{accountNumber}/credit")
    public ResponseEntity<String> creditBalance(
            @PathVaribale String accountNumber,
            @RequestParam BigDecimal amount){
    accountService.creditBalance(accountNumber, amount);
    return ResponseEntity.ok(body: "BALANCE CREDITED SUCCESSFULLY")
            }

}
