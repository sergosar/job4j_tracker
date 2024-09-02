package ru.job4j.bank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Класс описывает банковский аккаунт
 *
 * @author SNMiroshnichenko
 * @version 1.0
 */
public class BankService {
    /**
     * Поле для хранения пользователей со списком привязанных аккаунтов
     */
    private final Map<User, List<Account>> users = new HashMap<>();

    /**
     * Метод добавляет нового пользователя
     *
     * @param user пользователь, который добавляется в список пользователей
     */
    public void addUser(User user) {
        users.putIfAbsent(user, new ArrayList<>());
    }

    /**
     * Метод удаляет пользователя по паспарту
     *
     * @param passport паспорт пользователя
     */
    public void deleteUser(String passport) {
        users.remove(new User(passport, ""));
    }

    /**
     * Метод добавляет аккаунт пользователя по паспарту
     *
     * @param passport Метод возвращает пользователя по паспарту
     */
    public void addAccount(String passport, Account account) {
        User user = findByPassport(passport);
        if (user != null && !users.get(user).contains(account)) {
            users.get(user).add(account);
        }
    }

    /**
     * Метод возвращает пользователя по паспарту
     *
     * @param passport Метод возвращает пользователя по паспарту
     * @return возвращает пользователя по паспарту
     */

    public User findByPassport(String passport) {
        User result = null;
        for (User user : users.keySet()) {
            if (user.getPassport().equals(passport)) {
                result = user;
                break;
            }
        }
        return result;
    }

    /**
     * Метод ищет аккаунт по паспорту пользователя и реквизитам
     *
     * @param passport  паспорт пользователя
     * @param requisite реквизиты аккаунта
     * @return возвращает аккаунт по паспорту пользователя и реквизитам
     */
    public Account findByRequisite(String passport, String requisite) {
        User user = findByPassport(passport);
        if (user != null) {
            for (Account account : users.get(user)) {
                if (account.getRequisite().equals(requisite)) {
                    return account;
                }
            }
        }
        return null;
    }

    /**
     * Метод переводит деньги с одного аккаунта на другой
     *
     * @param sourcePassport       паспорт пользователя, со счета которого переводятся деньги
     * @param sourceRequisite      реквизиты аккаунта пользователя, со счета которого переводятся деньги
     * @param destinationPassport  паспорт пользователя, на счет которого переводятся деньги
     * @param destinationRequisite реквизиты аккаунта пользователя, на счет которого переводятся деньги
     * @param amount               количество денег
     * @return возвращает успешность операции
     */
    public boolean transferMoney(String sourcePassport, String sourceRequisite,
                                 String destinationPassport, String destinationRequisite,
                                 double amount) {
        boolean result = false;
        Account from = findByRequisite(sourcePassport, sourceRequisite);
        Account to = findByRequisite(destinationPassport, destinationRequisite);
        if (from != null && to != null && from.getBalance() >= amount) {
            to.setBalance(to.getBalance() + amount);
            from.setBalance(from.getBalance() - amount);
            result = true;
        }
        return result;
    }

    /**
     * Метод получает список аккаунтов пользователя
     *
     * @param user пользователь, для которого получаетя список аккаунтов
     * @return список аккаунтов пользователя
     */
    public List<Account> getAccounts(User user) {
        return users.get(user);
    }
}
