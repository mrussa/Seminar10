package backend.academy.seminar10.refactor_tasks.prime_generator;

public class PrimeGenerator {
    public int[] generate(int count) {
        if (count <= 0) {
            throw new IllegalArgumentException("count must be greater than 0");
        }

        int[] primes = new int[count];
        primes[0] = 2;

        int currentPrimeCount = 1;
        int currentPrime = 3;

        while (currentPrimeCount < count) {
            if (isPrime(currentPrime, primes, currentPrimeCount)) {
                primes[currentPrimeCount] = currentPrime;
                currentPrimeCount++;
            }
            currentPrime += 2;
        }
        return primes;
    }

    private boolean isPrime(int currentPrime, int[] primes, int currentPrimeCount) {
        for (int i = 0; i < currentPrimeCount; i++) {
            int p = primes[i];
            if (p * p > currentPrime) {
                break;
            }
            if (currentPrime % p == 0) {
                return false;
            }
        }
        return true;
    }
}
