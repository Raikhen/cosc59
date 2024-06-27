with Ada.Text_IO; use Ada.Text_IO;

procedure PrimePartitions is
  N : constant := 20;
  Big_Number : constant := 10000;
  
  type Prime_List is array (2 .. N) of Boolean;
  type Partition_List is array (1 .. Big_Number) of Prime_List;

  type Partition_List_With_Size is record
    List : Partition_List;
    Size : Integer range 1 .. Big_Number;
  end record;
  
  -- Returns the prime numbers up to N
  function Get_Primes return Prime_List is
    Prime : Prime_List := (others => True);
  begin
    for P in Prime'Range loop
      if Prime (P) then
        for N in 2 .. Positive'Last loop
          exit when N * P not in Prime'Range;
          Prime (N * P) := False;
        end loop;
      end if;
    end loop;
    
    return Prime;
  end Get_Primes;

  -- Returns the prime partitions of M
  function Get_Prime_Partitions return Partition_List is
    Partitions : Partition_List := (others => (others => False));
    --Subpartitions : Partition_List := (others => (others => False));
    --Number_Of_Partitions : Natural := 0;
  begin
    --if n < 2 then
    --  return Partitions;
    --end if;

    --for p in Prime'Range loop
    --  if n = p then
    --    Partitions (Number_Of_Partitions) (n) := True;
    --    Number_Of_Partitions := Number_Of_Partitions + 1;
    --  end if;
      
    --  Subpartitions := Get_Prime_Partitions(n - p, p + 1);

    --  for I in Subpartitions'Range loop
    --    exit when Sum_Partition (Subpartitions (p)) = 0;
    --    Subpartitions (Number_Of_Partitions) (p) := True;
    --    Number_Of_Partitions := Number_Of_Partitions + 1;
    --  end loop;

      --if len(smaller_partitions) > 0:
      --  for partition in smaller_partitions:
      --    partition.append(p)
        
      --  partitions += smaller_partitions
      
    --end loop;

    return Partitions;
  end Get_Prime_Partitions;
  
  -- Returns the sum of the partition
  function Sum_Partition (Partition : Prime_List) return Integer is
    Total : Integer range 0 .. N := 0;
  begin
    for i in Partition'Range loop
      if Partition (i) then
        Total := Total + i;
      end if;
    end loop;
    
    return Total;
  end Sum_Partition;

  -- Returns the size of the partition
  function Partition_Size (Partition: Prime_List) return Integer is
    Size : Integer range 0 .. N := 0;
  begin
    for I in Partition'Range loop
      if Partition (I) then
        Size := Size + 1;
      end if;
    end loop;
    
    return Size;
  end Partition_Size;
  
  -- Is there a value greater than or equal to I in the partition?
  function Value_Remaining
    (Partition : Prime_List;
    I : Integer) return Boolean is
  begin
    for J in 2 .. N loop
      if Partition (J) and J >= I then
        return True;
      end if;
    end loop;

    return False;
  end Value_Remaining;

  -- Removes the space at the beginning of the string after using 'Image
  function Remove_First_Space (Str : String) return String is
  begin
    return Str (2 .. Str'Last);
  end Remove_First_Space;

  -- Print the prime partitions of N
  procedure Print_Prime_Partitions is
    Partitions : Partition_List := Get_Prime_Partitions;
  begin
    for I in Partitions'Range loop
      exit when Sum_Partition (Partitions (I)) = 0;
      Put (N'Image);
      Put (" =");
      
      for J in 2 .. N loop
        if Partitions (I) (J) then
          Put (J'Image);
          
          if Value_Remaining (Partitions (I), J + 1) then
            Put (" +");
          end if;
        end if;
      end loop;

      Put (" (");
      Put (Remove_First_Space(Partition_Size (Partitions (I))'Image));
      Put(")");
    end loop;

    Put(N'Image);
    Put(" has");
    Put(Partitions'Length'Image); -- Replace for the number of partitions
    Put(" prime partitions.");
  end Print_Prime_Partitions;
begin
  Print_Prime_Partitions;
end PrimePartitions;