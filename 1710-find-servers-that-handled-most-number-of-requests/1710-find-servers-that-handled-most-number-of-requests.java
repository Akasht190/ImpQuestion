
//         \U0001f6a7 The Core Problem We're Solving
// You have:

// Multiple servers (from 0 to k-1)

// Each server can only process one request at a time

// Each request comes at a specific time and needs a fixed amount of processing time

// You need to assign incoming requests to the correct server, based on a special rule (i % k), or the next available one

// ⛔ Challenges:
// You need to know which servers are currently available at any given time

// You need to release servers when their current task is done (i.e., they’re no longer busy)

// You need to efficiently assign each incoming request to the right server, using the rules

// \U0001f4a1 Intuition: What Data Structures Help?
// \U0001f947 PriorityQueue — For Busy Servers
// Why?
// A server becomes available after its current request is finished

// So you need to track servers that are currently busy — and when they will become free

// java
// Copy
// Edit
// PriorityQueue<int[]> busy = new PriorityQueue<>((a, b) -> a[0] - b[0]);
// Each entry is:

// a[0] = time when the server becomes free

// a[1] = server ID

// This allows you to: ✅ Always get the server that becomes available soonest
// ✅ Check if it can be freed at or before the current time
// ✅ Efficiently remove and update servers (O(log k))

// \U0001f948 TreeSet — For Available Servers
// Why?
// You need to quickly find a server:

// Starting from (i % k)

// Or wrap around to the start (like a circle)

// So you need:

// A way to search for the next greater or equal server ID

// A way to remove servers once assigned

// A way to re-add them when they become available

// TreeSet provides all this:

// java
// Copy
// Edit
// TreeSet<Integer> available = new TreeSet<>();
// This allows you to: ✅ Do ceiling() to find the next available server ≥ (i % k)
// ✅ Do first() if wrapping around
// ✅ Add/remove server IDs in O(log k) time

// \U0001f4ad Real-Life Analogy
// Imagine:

// You run a restaurant with k waiters (servers)

// You have a list of customers (requests) arriving one by one

// A waiter can only serve one customer at a time

// To run the restaurant smoothly:

// You use a schedule (PriorityQueue) to know when each waiter becomes free

// You use a whiteboard (TreeSet) showing which waiters are currently free

// You always pick the next waiter according to some rule (modulo or round-robin)

// \U0001f9ee Time & Space Complexity
// \U0001f552 Time Complexity
// Let n = number of requests, k = number of servers

// Operation	Cost
// Each request	O(log k) (TreeSet and PriorityQueue ops)
// Freeing servers per request	O(log k) worst case
// Overall	O(n log k)
// \U0001f9e0 Space Complexity
// Data Structure	Space
// requestsHandled[]	O(k)
// busy Queue	O(k)
// TreeSet	O(k)
// Total	O(k)
// ✅ Summary: Why We Use Them
// Data Structure	Purpose	Why It's Good
// PriorityQueue	Track busy servers and their free time	Get earliest free server in O(log k)
// TreeSet	Manage available servers efficiently	Find next server, wrap around, remove in O(log k)
// These choices are perfect for problems where:

// You need to simulate real-time behavior (like servers becoming free)

// You need sorted access to available resources (like next available server)

        
import java.util.*;

public class Solution {
    public List<Integer> busiestServers(int k, int[] arrival, int[] load) {
        int n = arrival.length;

        // Step 1: Track how many requests each server has handled
        int[] requestsHandled = new int[k];

        // Step 2: PriorityQueue to keep track of busy servers: (freeTime, serverId)
        PriorityQueue<int[]> busy = new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0]));

        // Step 3: TreeSet to keep track of available server IDs (sorted and searchable)
        TreeSet<Integer> available = new TreeSet<>();
        for (int i = 0; i < k; i++) {
            available.add(i);
        }

        // Step 4: Process each request
        for (int i = 0; i < n; i++) {
            int time = arrival[i];
            int duration = load[i];

            // Step 4.1: Free up servers that have completed their tasks
            while (!busy.isEmpty() && busy.peek()[0] <= time) {
                int[] server = busy.poll();   // server[0] = freeTime, server[1] = serverId
                available.add(server[1]);     // put the server back to available list
            }

            if (available.isEmpty()) {
                continue; // all servers are busy, drop this request
            }

            // Step 4.2: Find the next available server >= i % k
            Integer serverId = available.ceiling(i % k);

            if (serverId == null) {
                // No server >= i % k, so wrap around and take the smallest one
                serverId = available.first();
            }

            // Assign the request to this server
            available.remove(serverId);
            busy.offer(new int[]{time + duration, serverId});  // server will be busy until (time + load)
            requestsHandled[serverId]++;  // increment this server's request count
        }

        // Step 5: Find max number of requests handled
        int maxRequests = 0;
        for (int count : requestsHandled) {
            maxRequests = Math.max(maxRequests, count);
        }

        // Step 6: Collect all servers that handled maxRequests
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            if (requestsHandled[i] == maxRequests) {
                result.add(i);
            }
        }

        return result;
    }
}
