#include <stdio.h>
#include <stdlib.h>
#include <math.h>

struct MEMORY
{
	int page_num;
	int reference_bit;
	int dirty_bit;
};

struct PAGE {
	int memory_location;
	int valid_bit;
};

int main(int argc, char *argv[])
{
	int memory_size = atoi(argv[1]);
	FILE * input_file = fopen("파일경로\\a.txt", "r");

	struct MEMORY * memory = (struct MEMORY *)malloc(memory_size * sizeof(struct MEMORY));
	for (int i = 0; i < memory_size; i++) {
		memory[i].reference_bit = 0;
		memory[i].dirty_bit = 0;
	}

	int page_size = 200000;
	struct PAGE * page = (struct PAGE *) malloc(page_size * sizeof(struct PAGE));
	for (int i = 0; i < page_size; i++) {
		page[i].valid_bit = 0;
	}

	int pg = 0;
	int op = 0;

	int page_fault = 0;
	int disk_write = 0;
	int head_movement = 0;
	int head = 0;

	int n = 0;
	int check = 0;

	while (!feof(input_file)) {
		fscanf(input_file, "%d %d", &pg, &op);

		if (page[pg].valid_bit == 1) {
			memory[page[pg].memory_location].reference_bit = 1;
			if (op == 1) {
				memory[page[pg].memory_location].dirty_bit = 1;
			}
		}

		else {
			page_fault += 1;

			while (check == memory_size) {
				n = n % memory_size;

				if (memory[n].reference_bit == 1) {
					memory[n].reference_bit = 0;
					n++;
				}
				else {
					page[memory[n].page_num].valid_bit = 0;
					if (memory[n].dirty_bit == 1) {
						disk_write += 1;
						head_movement += abs(head - (memory[n].page_num / 1000));
						head = memory[n].page_num / 1000;
						break;
					}
					break;
				}
			}

			head_movement += abs(head - (pg / 1000));
			head = (pg / 1000);
			memory[n].page_num = pg;
			memory[n].dirty_bit = op;
			memory[n].reference_bit = 0;
			page[pg].memory_location = n;
			page[pg].valid_bit = 1;
			n += 1;
			if (check < memory_size) {
				check++;
			}
		}
	}
	printf("Page fault count: %d\n", page_fault);
	printf("Disk write count: %d\n", disk_write);
	printf("Head movement count: %d\n", head_movement);
}