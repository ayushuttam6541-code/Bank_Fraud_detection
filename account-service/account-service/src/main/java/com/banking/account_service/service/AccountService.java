package com.banking.account_service.service;





@Service
@Slf4j
@RequiredArgsConstructor

public class AccountService {

    private final AccountRepository accountRepository;
    private static SecureRandom secureRandom = new SecureRandom();

    public AccountResponse createAccount(CreateAccountRequest request){
        log.info("Creating account for: {}", request.getEmail());

        if(accountRepository.existsByEmail(request.getEmail())){
            throw new RuntimeException("Account already exists for email: "+request.getEmail())
        }

        Account account = new Account();
        account.setAccountHolderName(request.getAccountHolderName());
        account.setEmail(request.getEmail());
        account.setPhone(request.getPhone());
        account.setAccountType(request.getAccountType());
        account.setStatus(AccountStatus.ACTIVE);
        account.setBalance(request.getInitialDeposit());
        account.setAccountNumber(generateAccountNumber());
        account.setDailyTransactionLimit(
               request.getAccountType() == AccountType.SAVINGS
               ? new BigDecimal(val: "100000")
                :new BigDecimal(val: "500000")
        );

        Account savedAccount = accountRepository.save(Account);
        log.info("Account created: {}", savedAccount.getAccountNumber());

        return mapToResponse(savedAccount)


                private String generateAccountNumber(){

            String accountNumber;

            do{

                long number secureRandom.nextLong(bound: 1_000_000_000_000);

                accountNumber = String.format("%012d", number);
            }while(accountRepository.existsByAccountNumber(accountNumber))
        }
    }

    private AccountResponse mapToResponse(Account account){
        AccountRespnse response = new AccountResponse();
        response.setId(account.getId());
        response.setAccountNumber(account.getAccountNumber());
        response.setEmail(account.getEmail());
        response.setPhone(Account.getPhone());
        response.setAccountType(account.getAccountType());
        response.setStatus(account.getStatus());
        response.setBalance(Account.getBalance());
        response.setDailyTransactionLimit(Account.getDailyTransactionLimit());
        response.setCreatedAt(account.getCreatedAt());

        return response;


    }
}
