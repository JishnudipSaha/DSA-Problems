import sys

# Fast I/O is essential for the 0.6s time limit
input_data = sys.stdin.read().split()
it = iter(input_data)

n = int(next(it))
m = int(next(it))
q = int(next(it))

names = [next(it) for _ in range(n)]
name_to_idx = {name: i for i, name in enumerate(names)}

parent = [-1] * n
children = [[] for _ in range(n)]
is_locked = [False] * n
locked_by = [-1] * n
locked_desc = [0] * n

# Build tree in O(n)
for i in range(1, n):
    p = (i - 1) // m
    parent[i] = p
    children[p].append(i)

# Fixed spelling to 'ancestor' for clarity
def has_locked_ancestor(i):
    p = parent[i]
    while p != -1:
        if is_locked[p]: return True
        p = parent[p]
    return False

def update_ancestors(i, delta):
    p = parent[i]
    while p != -1:
        locked_desc[p] += delta
        p = parent[p]

def lock_node(i, uid):
    if is_locked[i] or locked_desc[i] > 0 or has_locked_ancestor(i):
        return False
    is_locked[i] = True
    locked_by[i] = uid
    update_ancestors(i, 1)
    return True

def unlock_node(i, uid):
    if not is_locked[i] or locked_by[i] != uid:
        return False
    is_locked[i] = False
    locked_by[i] = -1
    update_ancestors(i, -1)
    return True

def upgrade_node(i, uid):
    if is_locked[i] or has_locked_ancestor(i) or locked_desc[i] == 0:
        return False
    
    locked_nodes = []
    stack = [i]
    while stack:
        curr = stack.pop()
        for ch in children[curr]:
            if is_locked[ch]:
                if locked_by[ch] != uid: return False
                locked_nodes.append(ch)
            elif locked_desc[ch] > 0:
                stack.append(ch)
    
    if not locked_nodes: return False
    
    for ln in locked_nodes:
        is_locked[ln] = False
        locked_by[ln] = -1
        update_ancestors(ln, -1)
        
    is_locked[i] = True
    locked_by[i] = uid
    update_ancestors(i, 1)
    return True

# --- FIXED QUERY LOOP ---
out = []
for _ in range(q):
    try:
        t = int(next(it))
        name = next(it) # <--- REMOVED int() HERE
        uid = int(next(it))
        idx = name_to_idx[name]
        
        if t == 1: out.append("true" if lock_node(idx, uid) else "false")
        elif t == 2: out.append("true" if unlock_node(idx, uid) else "false")
        elif t == 3: out.append("true" if upgrade_node(idx, uid) else "false")
    except StopIteration:
        break

sys.stdout.write('\n'.join(out) + '\n')